package com.example.a01linearlayoutusingthelayouteditor


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }
        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }
    }

    //버튼을 누르면
    private fun addNickname(view: View){//view = done_button
        val editText = findViewById<EditText>(R.id.nickname_edit)//editText에 nickname_edit값 삽입
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        nicknameTextView.text = editText.text//nicknameTextBiew = 입력한 editText의 text값
        editText.visibility = View.GONE //editText의 가시성 -> gone
        view.visibility = View.GONE//view = done_button의 가시성 -> gone
        nicknameTextView.visibility = View.VISIBLE//nicknameTextView의 가시성 -> visible

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager //InputMethodManager타입으로
        //getSystemService = 관리 매니저 객체 반영,INPUT_METHOD_SERVICE 문자 입력 메소드에 접근하기 위해 같이 사용
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        //hideSoftInputFromWindow = 입력창을 가리기 위한 요청
    }
    /*
    즉 처음 nickname_edit 레이아웃에 이름을 입력후 버튼을 클릭하면
    editText의 nickname_edit값을 넣은 후 nicknameTextView 프로퍼티엔 nickname_text id값을 삽입
    그 후 nickanameTextView의 텍스트 값(nickname_text.text)에 editText의 텍스트값을 입력한 후
    editText와, view(done_button)의 가시성을 gone으로
    nickanameTextView(nickname_text.visibility)의 가시성을 Visibility로 변경하여 텍스트를 보여줌
    */
    private fun updateNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<TextView>(R.id.done_button)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        
        editText.requestFocus()//nickname_text클릭시 editText에 현재 포커스를 받는것을 알려줌, 커서가 나타남

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
        //nickname_text 클릭시 실행시 키보드 나타나게
    }
    /*
    위와 비슷, 반대로 화면에 보이는 nickname_text를 클릭하게 되면 숨겨놓았던
    editText와 doneButton의 가시성을 visibility로 변경
    텍스트 변경후 doneButton을 누르면 다시시 addNickname(view:View)가 실행
    */
}

