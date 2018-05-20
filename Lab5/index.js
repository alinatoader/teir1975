var questions = [{enunt: "Ce inseamna OOP?", raspuns1: "Object Oriented Programming", raspuns2: "raspuns gresit", raspuns3: "alt raspuns gresit", raspunsCorect: "1", domeniu: "Programare"}]
$(document).ready(function(){
	showQuestions();

	$("form").submit(function(event){
		event.preventDefault();
		questions.push({enunt: this.Enunt.value, raspuns1: this.Raspuns1.value, raspuns2: this.Raspuns2.value, raspuns3: this.Raspuns3.value, raspunsCorect: this.RaspunsCorect.value, domeniu: this.Domeniu.value});
		showQuestions();
	});
});

function showQuestions(){
	var questionsView = "<table> <thead> <th> Enunt</th> <th> Raspuns1</th><th>Raspuns2</th> <th> Raspuns3</th> <th> Raspuns Corect</th> <th> Domeniu</th></thead><tbody>";
	for(var i=0;i<questions.length;i++)
	{
		questionsView+="<tr ><td name=\"enuntCol\">"+questions[i].enunt+"</td><td>" + questions[i].raspuns1 + "</td><td>" + questions[i].raspuns2 + "</td><td>" + questions[i].raspuns3 + "</td><td>" + questions[i].raspunsCorect + "</td><td>" + questions[i].domeniu + "</td></tr>";
	}
	questionsView+="</tbody></table>";
	$("#questions").html(questionsView);
}