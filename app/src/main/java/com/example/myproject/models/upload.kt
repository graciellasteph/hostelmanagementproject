package com.example.myproject.models


class upload {
    var name:String=""
    var hostel : String=""
    var fee : String=""
    var imageUrl:String=""
    var id : String=""

    constructor(name:String,hostel:String,fee:String,imageUrl:String,id:String){

        this.name=name
        this.hostel=hostel
        this.fee=fee
        this.imageUrl =imageUrl
        this.id=id
    }
    constructor()
}