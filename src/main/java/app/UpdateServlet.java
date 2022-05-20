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

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
    @SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	/*
         * 下記のコメントを参考に必要な処理を実装してください
         */

        // todo:入力値取得
    	request.setCharacterEncoding("UTF-8");
    	String bodyColor = request.getParameter("bodyColor");
    	String speed = request.getParameter("speed");
    	String btn = request.getParameter("btn");

        // todo:「最初に戻る」ボタンクリック時、「input.jsp」へ遷移
    	if(btn.equals("back")) {
    		request.getRequestDispatcher("input.jsp").forward(request, response);
    		
    	}

        // todo:数値項目の入力値を数値に変換
    	int speedInt = Integer.parseInt(speed);


        // セッションを取得
        HttpSession session = request.getSession();

        // セッションより変更履歴情報を取得
        // (警告が出るが、無視して良い)
        ArrayList<Car> historyList = (ArrayList<Car>) session.getAttribute("historyList");

        // 変更履歴情報から最新のCarオブジェクトを取得
        // historyListの一番最後に保存されているCarオブジェクトが
        // 最新の情報を保持している
        Car latestCar = (Car) historyList.get(historyList.size()-1);

        // todo:変更後の情報を保持するためのCarオブジェクトを新規作成
        // 最新の情報を使用して、新しくCarオブジェクトを作成する
        // (latestCarが保持している値を引数に指定する)
        // 現在はnullをセットしている
        Car newCar = new Car(latestCar.getCarName(),bodyColor,latestCar.getMaxSpeed(),speedInt);

        // todo:セッターを使って、車体の色(入力値)をセット
        newCar.setBodyColor(bodyColor);

        // todo:セッターを使って、現在の速度(入力値)をセット
        newCar.setSpeed(speedInt);

        // todo:historyListに、上で作成した変更後の情報を保持したオブジェクト(newCar)を追加
        historyList.add(newCar);

        // todo:セッションに変更履歴情報(historyList)を登録
        session.setAttribute("historyList", historyList);

        //セッションに最新情報を登録
        session.setAttribute("latestCar", newCar);

        // メッセージをセット
        request.setAttribute("result","車体の色と現在速度を変更しました");

        // 結果画面へ遷移
        request.getRequestDispatcher("update.jsp").forward(request, response);

    }
}
