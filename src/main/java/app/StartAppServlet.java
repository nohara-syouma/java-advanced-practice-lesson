package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/StartAppServlet")
public class StartAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StartAppServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String example = request.getParameter("example");

		String result = "アプリの実行に失敗しました。";

		System.out.println(name);

		request.setAttribute("name", name);
		
		App app = null;
		
		if(example.equals("トランプ")) {
			
			app = new CardGameApp(example);
			
		}else if(example.equals("ダーツ")) {
			
			app = new DartsGameApp(example);
			
		}else {
			
			app = new ClockApp();
			
		}
		
		if(app instanceof GameApp) {
			
			GameApp gameApp = (GameApp)app;  // 変数appの型を「App」から「GameApp」へ変換

			request.setAttribute("time", gameApp.getPlayTime());
		}

		if (example.equals("トランプ")) {

			App tr = new CardGameApp(example);

			result = tr.start(name);

			request.setAttribute("info", result);

		}else if(example.equals("ダーツ")) {
			
			App da = new DartsGameApp(example);
			
			result = da.start(name);

			request.setAttribute("info", result);
			
			
		}else if(example.equals("時計")) {
			
			App cl = new ClockApp();
			
			result = cl.start(name);
			
			request.setAttribute("info", result);
			
		}else{
			
			request.setAttribute("info", result);
			
		}

		request.getRequestDispatcher("/appStart.jsp").forward(request, response);

	}

}
