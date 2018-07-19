package es.udc.fic.tfg.expense;

import java.security.Principal;

import es.udc.fic.tfg.pdf.CreatePDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import es.udc.fic.tfg.activity.Activity;
import es.udc.fic.tfg.activity.ActivityRepository;
import es.udc.fic.tfg.training.Training;
import es.udc.fic.tfg.training.TrainingRepository;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class ExpenseDetailsController {

	private static final String EXPENSEDETAILS_VIEW_NAME = "expense/expenseDetails";

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ExpenseService expenseService;

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private TrainingRepository trainingRepository;

	@GetMapping("expense/expenseDetails/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String expense(@PathVariable("id") Long id, Model model,
			@RequestHeader(value = "X-Requested-With", required = false) String requestedWith, Principal principal) {
		Account account = accountRepository.findOneByEmail(principal.getName());
		Expense expense = expenseService.findOneById(id);
		model.addAttribute("expense", expense);

		return EXPENSEDETAILS_VIEW_NAME;
	}

	@GetMapping("expense/expenseDetails/delete/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String expense(@PathVariable("id") Long id, Model model,
			@RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
		Expense expense = expenseService.findOneById(id);
		Activity a = activityRepository.findByActivityexpense(expense);
		if (a != null) {
			a.setActivityexpense(null);
			activityRepository.save(a);
		}
		
		Training t = trainingRepository.findByTrainingexpense(expense);
		if (t!=null) {
			t.setTrainingexpense(null);
			trainingRepository.save(t);
		}
		expenseService.delete(expense);
		return "/home/homeSignedIn";
	}


	@GetMapping("expense/expenseDetails/generate-pdf/{id}")
	void pdf(Principal principal,@PathVariable("id") Long id, HttpServletResponse response,HttpServletRequest request) {

		Account account = accountRepository.findOneByEmail(principal.getName());
		Expense expense = expenseService.findOneById(id);
		String fileName = "Factura-"+expense.getHorseexpense().getNickname()+".pdf";
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename="+ fileName);
		final ServletContext servletContext = request.getSession().getServletContext();
		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();
		try {

			CreatePDF.createPDF(temperotyFilePath+"\\"+fileName, expense);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos = convertPDFToByteArrayOutputStream(temperotyFilePath+"\\"+fileName);
			OutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {

		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {

			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();

			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}


}
