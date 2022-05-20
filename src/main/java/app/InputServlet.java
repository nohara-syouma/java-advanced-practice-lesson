package jp.co.axiz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.entity.Car;
import jp.co.axiz.util.Utility;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/inputServlet")
public class InputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
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

    	/*
         * 下記のコメントを参考に必要な処理を実装してください
         */

        // todo:入力値取得
    	
    	request.setCharacterEncoding("UTF-8");

		String carName = request.getParameter("carName");
		String bodyColor = request.getParameter("bodyColor");
		String maxSpeed = request.getParameter("maxSpeed");
		
		String result = "未入力の項目があります"; 

        // todo:未入力チェック
        // (入力値の3つのうち、どれか一つでも未入力なら「input.jsp」へ戻る
        //  未入力かどうかの判定は、UtilityクラスのisNullOrEmptyメソッドを使用)
		//Utility utility = new Utility();
		if(Utility.isNullOrEmpty(carName) || Utility.isNullOrEmpty(bodyColor) || Utility.isNullOrEmpty(maxSpeed)) {
			request.setAttribute("result", result);
			request.getRequestDispatcher("input.jsp").forward(request, response);
			
		}

        // todo:数値に変換
        // (数値項目[最高速度]の入力値の値を数値に変換)
		int maxSpeedInt = Integer.parseInt(maxSpeed);

        // todo:Carオブジェクト作成
        // 現在はnullをセットしている。Carオブジェクトを作成し、
        // フィールドに入力値をセットする。
        Car car = new Car(carName, bodyColor, maxSpeedInt);
        System.out.println(car);
        // セッションを取得
        HttpSession session = request.getSession();

        // 変更履歴情報(ArrayListオブジェクト)を新規作成
        ArrayList<Car> historyList = new ArrayList<>();

        // todo:historyListに上で作成したCarオブジェクトを追加
        historyList .add(car);
        
        System.out.println(historyList);

        // todo:セッションに変更履歴情報(historyList)を登録
        session.setAttribute("historyList", historyList);

        //セッションに最新情報を登録
        session.setAttribute("latestCar", car);


        // 結果画面へ遷移
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
