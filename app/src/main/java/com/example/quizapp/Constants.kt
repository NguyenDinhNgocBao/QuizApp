package com.example.quizapp

object Constants{

    const val TOTAL_QUESTIONS: String = "user_name"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions() : ArrayList<Questions>{
        val questionList = ArrayList<Questions>()
        questionList.add(
            Questions(1,
                "Which country is this city in?",
                R.drawable.bangkok,
                "Thailand",
                "Indonesia",
                "Laos",
                "VietNam",
                1)
        )
        questionList.add(
            Questions(2,
                "Which country is this city in?",
                R.drawable.barcelona,
                "Spain",
                "Portugal",
                "Maroc",
                "Italy",
                1)
        )
        questionList.add(
            Questions(3,
                "Which country is this city in?",
                R.drawable.hongkong,
                "Japan",
                "VietNam",
                "Singapore",
                "China",
                4)
        )
        questionList.add(
            Questions(4,
                "Which country is this city in?",
                R.drawable.london,
                "France",
                "Portugal",
                "England",
                "Holland",
                3)
        )
        questionList.add(
            Questions(5,
                "Which country is this city in?",
                R.drawable.hue,
                "VietNam",
                "China",
                "Mexico",
                "Malaysia",
                1)
        )
        questionList.add(
            Questions(6,
                "Which country is this city in?",
                R.drawable.moskva,
                "Germany",
                "Russia",
                "India",
                "Turkey",
                2)
        )
        questionList.add(
            Questions(7,
                "Which country is this city in?",
                R.drawable.newyork,
                "Canada",
                "Australia",
                "America",
                "Brazil",
                3)
        )
        questionList.add(
            Questions(8,
                "Which country is this city in?",
                R.drawable.paris,
                "Spain",
                "France",
                "Sweden",
                "Denmark",
                2)
        )
        questionList.add(
            Questions(9,
                "Which country is this city in?",
                R.drawable.saigon,
                "Japan",
                "China",
                "VietNam",
                "Cambodian",
                3)
        )
        questionList.add(
            Questions(10,
                "Which country is this city in?",
                R.drawable.seoul,
                "Korea",
                "Japan",
                "China",
                "VietNam",
                1)
        )
        questionList.add(
            Questions(11,
                "Which country is this city in?",
                R.drawable.tokyo,
                "Russia",
                "Korea",
                "Switzerland",
                "Japan",
                4)
        )
        questionList.add(
            Questions(12,
                "Which country is this city in?",
                R.drawable.toronto,
                "Russia",
                "America",
                "Finland",
                "Canada",
                4)
        )
        questionList.add(
            Questions(13,
                "Which country is this city in?",
                R.drawable.sysney,
                "Australia",
                "America",
                "China",
                "Japan",
                1)
        )
        questionList.add(
            Questions(14,
                "Which country is this city in?",
                R.drawable.singapore,
                "Australia",
                "Singapore",
                "Malaysia",
                "Japan",
                2)
        )
        questionList.add(
            Questions(15,
                "Which country is this city in?",
                R.drawable.italia,
                "Chile",
                "Denmark",
                "Italia",
                "Russia",
                3)
        )
        return questionList
    }
}