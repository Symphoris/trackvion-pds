
package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
// javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; import
javax.servlet.http.HttpServletResponse;

import beans.Candidate;
import beans.ConnectedBathtub;
import beans.ConnectedBlinds;
import beans.ConnectedBulbs;
import beans.ConnectedHobs;
import business.CandidateForm;
import business.ConfBathtubInsert;
import business.ConfBlindsinsert;
import business.ConfBulbsInsert;
import business.ConfBulbsUpdate;
import business.ConfHobsInsert;
import business.MapOC;
import business.UseBathtubInsert;
import business.UseBathtubUpdate;
import business.UseBlindsInsert;
import business.UseBlindsUpdate;
import business.UseBulbsInsert;
import business.UseBulbsUpdate;
import business.UseHobsInsert;
import business.UseHobsUpdate;
import common.NotifierHandler;





public class ConfigurationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	public ConfigurationServlet() { 
		super(); 
	}

	public static int apartmentId = 7;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		try {
			apartmentId = Integer.parseInt(request.getPathInfo().substring(1));

		} catch (Exception e) {
			NotifierHandler.setNotifierMessage(request, e.getMessage());
			response.sendRedirect("/tv/apartmentOC"); 
			return;
		} 

		request.setAttribute("apartmentId", apartmentId);


		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/utilisation.jsp");
		view.forward(request, response);

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int maxWater = 0; 
		int bathNiveauEau = 0;
		int bathTemp =0;

		//ConnectedBathtub bath = new ConnectedBathtub();
		//		ConnectedBlinds blinds = new ConnectedBlinds();
		//		ConnectedBulbs bulbs = new ConnectedBulbs();
		//		ConnectedHobs hobs = new ConnectedHobs();


		String strBlind = request.getParameter("dureeOuvertmax");
		String strBath = request.getParameter("niveauEau");
		String strbulb = request.getParameter("actMax");
		String strBulbBright = request.getParameter("degreluminosite");
		String strHob = request.getParameter("durMaxAct");


		String strBlindOff = request.getParameter("off2");
		String strBlindopenTime = request.getParameter("openTime");
		String strBulbOff = request.getParameter("off");
		String strBlulbBright = request.getParameter("bright");
		String strHobOff = request.getParameter("off3");
		String strHobTemp = request.getParameter("hobTemp");
		String strBathNiveauEau = request.getParameter("niveauEau2");
		String strBathTemp = request.getParameter("degreTemperature2");



		//Configuration du 1er OC
		if (strBath != null && !strBath.isEmpty() )
		{

			try {
				maxWater = Integer.parseInt(strBath);
			}catch(Exception e)
			{
				request.setAttribute("optionalMessage", "Wrong configuration ! "); 

				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
				view.forward(request, response);
			}


		}else {
			maxWater = 80;
		}

		if (strBathNiveauEau != null && !strBathNiveauEau.isEmpty())
		{
			try {

				bathNiveauEau = Integer.parseInt(strBathNiveauEau);
			}catch(Exception e)
			{
				request.setAttribute("optionalMessage", "Wrong configuration ! "); 

				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
				view.forward(request, response);
			}
		}

		if (strBathTemp != null && !strBathTemp.isEmpty())
		{
			try {
				bathTemp = Integer.parseInt(strBathTemp);
			}catch(Exception e)
			{
				request.setAttribute("optionalMessage", "Wrong configuration ! "); 

				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
				view.forward(request, response);
			}


		}


		//Configuration du 2ème OC
		int openTime = 0; 
		int blindOff;
		int blindopenTime = 0;

		if(strBlindOff.toUpperCase().equals("ON"))
		{
			blindOff = 1;
		}else {
			blindOff = 0;
		}


		if (strBlindopenTime != null && !strBlindopenTime.isEmpty())
		{
			try {
				blindopenTime = Integer.parseInt(strBlindopenTime);
			}catch(Exception e)
			{
				request.setAttribute("optionalMessage", "Wrong configuration ! "); 

				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
				view.forward(request, response);
			}
		} else 
		{
			blindopenTime =60;
		}

		if (strBlind != null && !strBlind.isEmpty())
		{
			try {
				openTime = Integer.parseInt(strBlind);
			}catch(Exception e)
			{
				request.setAttribute("optionalMessage", "Wrong configuration ! "); 

				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
				view.forward(request, response);
			}
		}else {
			openTime= 100;
		}

		//Configuration du 3ème OC

		int operTime = 0;
		int bulbOff=0;
		int blulbBright = 0;

		if(strBulbOff.toUpperCase().equals("ON"))
		{
			bulbOff = 1;
		}else {
			bulbOff = 0;
		}

		if (strBlulbBright != null && !strBlulbBright.isEmpty())
		{
			try {
				blulbBright= Integer.parseInt(strBlulbBright);
			}catch(Exception e)
			{
				request.setAttribute("optionalMessage", "Wrong configuration ! "); 

				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
				view.forward(request, response);
			}
		}else {
			blulbBright = 10;
		}

		if (strbulb != null && !strbulb.isEmpty())
		{
			try {
				operTime= Integer.parseInt(strbulb);
			}catch(Exception e)
			{
				request.setAttribute("optionalMessage", "Wrong configuration ! "); 

				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
				view.forward(request, response);
			}
		}else {
			operTime = 120;
		}

		int bright = 0 ;
		if (strBulbBright != null && !strBulbBright.isEmpty() )
		{
			try {
				bright= Integer.parseInt(strBulbBright);
			}catch(Exception e)
			{
				request.setAttribute("optionalMessage", "Wrong configuration ! "); 

				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
				view.forward(request, response);
			}
		}else {
			bright = 20;
		}

		//Configuration du 4ème OC

		int act = 0 ;
		int hobOff=0;
		int hobTemp = 0;

		if(strHobOff.toUpperCase().equals("ON"))
		{
			hobOff = 1;
		}else {
			hobOff = 0;
		}


		if (strHobTemp != null && !strHobTemp.isEmpty())
		{

			try {
				hobTemp =Integer.parseInt(strHobTemp);
			}catch(Exception e)
			{
				request.setAttribute("optionalMessage", "Wrong configuration ! "); 

				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
				view.forward(request, response);
			}
		}else 
		{
			hobTemp =100;
		}



		if (strHob != null && !strHob.isEmpty())
		{
			try {
				act =Integer.parseInt(strHob);
			}catch(Exception e)
			{
				request.setAttribute("optionalMessage", "Wrong configuration ! "); 

				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
				view.forward(request, response);
			}
		}else {
			act =120;
		}


		// To Call database

		ConfBathtubInsert bathinsert = new ConfBathtubInsert(maxWater,apartmentId);
		ConfBulbsInsert bulbinsert = new ConfBulbsInsert(operTime,apartmentId);
		ConfBulbsUpdate bulbupdate = new ConfBulbsUpdate(bright,apartmentId);
		ConfBlindsinsert blindsinsert = new ConfBlindsinsert(openTime,apartmentId);
		ConfHobsInsert hobsinsert = new ConfHobsInsert(act,apartmentId);

		UseBathtubInsert useBathtubInsert = new UseBathtubInsert(bathNiveauEau,apartmentId);
		UseBathtubUpdate useBathtubUpdate = new UseBathtubUpdate(bathTemp,apartmentId);
		UseBulbsInsert useBulbsInsert = new UseBulbsInsert(bulbOff,apartmentId);
		UseBulbsUpdate useBulbsUpdate = new UseBulbsUpdate(blulbBright,apartmentId);
		UseBlindsInsert useBlindsInsert = new UseBlindsInsert(blindOff,apartmentId);
		UseBlindsUpdate useBlindsUpdate = new UseBlindsUpdate(blindopenTime,apartmentId);
		UseHobsInsert useHobsInsert = new UseHobsInsert(hobOff,apartmentId);
		UseHobsUpdate useHobsUpdate = new UseHobsUpdate(hobTemp,apartmentId);




		if(bathinsert.executeInscription())
		{
			if(bulbinsert.executeInscription())
			{
				if(blindsinsert.executeInscription())
				{
					if(bulbupdate.executeInscription())
					{
						if(hobsinsert.executeInscription())
						{
							if(useBathtubInsert.executeInscription())
							{
								if(useBathtubUpdate.executeInscription())
								{
									if(useBulbsInsert.executeInscription())
									{
										if(useBulbsUpdate.executeInscription())
										{
											if(useBlindsInsert.executeInscription())
											{
												if(useBlindsUpdate.executeInscription())
												{
													if(useHobsInsert.executeInscription())
													{
														if(useHobsUpdate.executeInscription())
														{

															request.setAttribute("optionalMessage", "succesfull configuration !");
															RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
															view.forward(request, response);
														}else
														{
															request.setAttribute("optionalMessage", "A problem occured during the process "); 

															RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
															view.forward(request, response);
														}

													}else
													{
														request.setAttribute("optionalMessage", "A problem occured during the process "); 

														RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
														view.forward(request, response);
													}
												}else
												{
													request.setAttribute("optionalMessage", "A problem occured during the process "); 

													RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
													view.forward(request, response);
												}
											}else
											{
												request.setAttribute("optionalMessage", "A problem occured during the process "); 

												RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
												view.forward(request, response);
											}
										}else
										{
											request.setAttribute("optionalMessage", "A problem occured during the process "); 

											RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
											view.forward(request, response);
										}
									}else
									{
										request.setAttribute("optionalMessage", "A problem occured during the process "); 

										RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
										view.forward(request, response);
									}
								}else
								{
									request.setAttribute("optionalMessage", "A problem occured during the process "); 

									RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
									view.forward(request, response);
								}
							}
							else
							{
								request.setAttribute("optionalMessage", "A problem occured during the process "); 

								RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
								view.forward(request, response);
							}
						}else
						{
							request.setAttribute("optionalMessage", "A problem occured during the process "); 

							RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
							view.forward(request, response);
						}
					}else
					{
						request.setAttribute("optionalMessage", "A problem occured during the process "); 

						RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
						view.forward(request, response);
					}

				}else
				{
					request.setAttribute("optionalMessage", "A problem occured during the process "); 

					RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
					view.forward(request, response);
				}
			}else
			{
				request.setAttribute("optionalMessage", "A problem occured during the process "); 

				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
				view.forward(request, response);
			}
		}

		else
		{
			request.setAttribute("optionalMessage", "A problem occured during the process "); 

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/utilisation.jsp");
			view.forward(request, response);
		}
	
	}

}
