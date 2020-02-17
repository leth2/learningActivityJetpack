package com.example.ralativelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //액티비티 내에서 프래그먼트 트랜잭션을 수행하려면(예: 프래그먼트 추가, 제거, 교체) FragmentTransaction에서 가져온 API를 사용해야 합니다.
        val fragmentManger = supportFragmentManager
        val fragmentTransaction = fragmentManger.beginTransaction()

        val fragment = ExampleFragment()

        //activity의 layout에 fragment가 들어갈 자리를 지정해둬야 한다.
        fragmentTransaction.add(R.id.fragmentTest,fragment)

        //FragmentTransaction을 변경하고 나면, 반드시 commit()을 호출해야 변경 내용이 적용됩니다.
        fragmentTransaction.commit()

        //fragment관리
        //백 스택??
        //액티비티에서 프래그먼트를 사용하는 경우에는 특히 사용자 상호작용에 응답하여 추가, 제거, 교체 및 다른 작업을 수행할 수 있다는 점이 유용합니다.


    }
}
