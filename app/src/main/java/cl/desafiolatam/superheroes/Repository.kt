package cl.desafiolatam.superheroes


import cl.desafiolatam.superheroes.data.SuperApplication


class Repository {

    private val heroesDatabase = SuperApplication.superDataBase!!
    val heroesList = heroesDatabase.superDao().getSuper()



    }





