package tibame.activity.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import tibame.activity.service.TripService;
import tibame.activity.service.impl.TripServiceImpl;
import tibame.activity.vo.Trip;


@WebServlet("/SelectFilterActCityController")
public class SelectFilterActCityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TripService tripservice;
	
    public SelectFilterActCityController() {
       
    }

    //init()初始化頁面(必寫)，只要不執行生命週期的destroy()，它就永遠都會在
  	@Override
  	public void init() throws ServletException {
  		tripservice = new TripServiceImpl();
  	}
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//建立Gson物件，用於轉換JSON格式資料(前端傳來的資料)，與Java物件資料做轉換
		Gson gson = new Gson();
		Trip trip = gson.fromJson(request.getReader(), Trip.class);
		
		tripservice.showActCity(trip.getT_act_city());
		
		response.getWriter().write(gson.toJson(trip));
	}

}
