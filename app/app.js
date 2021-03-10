var app = angular.module('myApp', [])

app.controller('monController', ['$scope','$http', function(scope, http){

  class Question{
    constructor(libelle, color, image, yes, no){
      this.libelle =  libelle,
          this.color = color,
          this.image = image,
          this.yes = yes,
          this.no = no
    }
    display = function(){
      console.log("libelle : ", this.libelle);
      console.log("color : ", this.color);
      console.log("image : ", this.image);
      console.log("yes : ", this.yes);
      console.log("no : ", this.no);
    }
  }
  var fil = "";
  question = new Question();
  scope.jobs = [];
  scope.style={
    "background-color":"",
    "background-image": "",
    "background-size": "200px",
    "background-position": "center"
  }
  scope.questionVisible = false;
  scope.startVisible = true;
  scope.blocResult = false;
  console.log("jcrompred r ", scope.libelle);
  scope.start = function (){
    AskForTree();
    scope.startVisible = false;
    scope.questionVisible = true;
    scope.libelle = question.libelle;
  }
  scope.YesClick = function(){
    if(question.yes.type=="question"){
      nextQuestion(question.yes)
      question.display();
      console.log("jcrompred r ", scope.libelle);
    }else{
      userInterest={
        "agriculture":question.yes.agriculture,
        "social":question.yes.social,
        "mathematiques":question.yes.mathematiques,
        "commerce":question.yes.commerce,
        "medical":question.yes.medical,
        "manager":question.yes.manager,
        "informatique":question.yes.informatique
      };
      question.display();
      seeResult();
    }
  }
  scope.NoClick = function(){
    if(question.yes.type=="question"){
      nextQuestion(question.no)
      question.display();
    }else{
      userInterest={
        "agriculture":question.no.agriculture,
        "social":question.no.social,
        "mathematiques":question.no.mathematiques,
        "commerce":question.no.commerce,
        "medical":question.no.medical,
        "manager":question.no.manager,
        "informatique":question.no.informatique
      };
      question.display();
      seeResult();
    }}
  //____________________________________________________________________________________________________________________
  // SENDING HTTP REQUEST Arbre
  //____________________________________________________________________________________________________________________

  function AskForTree() {
    var req = {
      method: 'GET',
      url: 'http://localhost:8080/FindYouJob_war/tree',
      headers: {
        'Content-Type': 'application/json'},
    }
    http(req).then(function successCallback(response) {
      console.log("réponse obtenue");
      outputDataTree(response.data);
    }, function errorCallback(response) {
      console.log("erreur");
    });
  }
  function outputDataTree(data){
    console.log("objet : ", data["libelle"]);
    nextQuestion(data)
    question.display();
  }
  function nextQuestion(data)
    {
      question.intitule = data["libelle"];
      question.color = data["color"];
      question.image = data["image"];
      question.yes = data["yes"];
      question.no = data["no"];
      scope.libelle=data["libelle"];
      scope.color = question.color;
      scope.image = question.image;
      scope.style["background-color"]=question.color;
      scope.style["image"]="url(".concat(question.image).concat(")");
    }
  //____________________________________________________________________________________________________________________
  // SENDING HTTP REQUEST Resultat
  //____________________________________________________________________________________________________________________
  function seeResult(){
    sendRequest();
    scope.questionVisible = false;
    scope.blocResult = true;
  }
  function sendRequest() {
    var req = {
      method: 'POST',
      url: 'http://localhost:8080/FindYouJob_war/qcm',
      headers: {
        'Content-Type': 'application/json'},
      data:JSON.stringify(userInterest)
    }
    console.log(userInterest);
    http(req).then(function successCallback(response) {
      console.log("réponse obtenue");
      outputData(response.data);
    }, function errorCallback(response) {
      console.log("pas de réponse obtenue");
    });
  }

  function outputData(data){
    console.log("objet : ", data);
    console.log("type : ", typeof(data));
    console.log("taille : ", data.results.length)
    for(i=0; i<data.results.length; i++ ) {
      if (!scope.jobs.includes((data.results[i]["libelle_metier"]))) {
        scope.jobs.push(data.results[i]["libelle_metier"])
        console.log(data.results[i]["libelle_metier"]);
      }
    }
  }
}])