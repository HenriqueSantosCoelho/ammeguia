Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
  Chart.defaults.global.defaultFontColor = '#858796';
  angular.module('dashboard',[]).controller('am',function($scope,$http){
    var tipos = {
      BURACO:0, FALTA_DE_PISO_TATIL:0, CALCADA_IRREGULAR:0, RAMPA_INADEQUADA:0, OUTRO_PROBLEMA:0
    }
    $http({
      method:'GET',
      url:'https://serene-thicket-17017.herokuapp.com/problema/listar'
    }).then(function(response){
      response.data.forEach(p => {
        var tipo = p.tipo;
        switch(tipo){
          case 'BURACO':
            tipos.BURACO +=1;
            break;
          case 'FALTA_DE_PISO_TATIL':
            tipos.FALTA_DE_PISO_TATIL +=1;
            break;
          case 'CALCADA_IRREGULAR':
            tipos.CALCADA_IRREGULAR +=1;
            break;
          case 'RAMPA_INADEQUADA':
            tipos.RAMPA_INADEQUADA +=1;
            break;
          default:
            tipos.OUTRO_PROBLEMA +=1;
            break;
        }
      });
      updateChart();
    });
  
  
  // Set new default font family and font color to mimic Bootstrap's default styling
  function updateChart(){
    var ctx = document.getElementById("myPieChart");
    var myPieChart = new Chart(ctx, {
      type: 'doughnut',
      data: {
        labels: ["Falta de Piso Tatil", "Rampas Inadequadas", "Buracos na via","Calçadas irregulares","Outros"],
        datasets: [{
          data: [tipos.FALTA_DE_PISO_TATIL, tipos.RAMPA_INADEQUADA, tipos.BURACO,tipos.CALCADA_IRREGULAR,tipos.OUTRO_PROBLEMA],
          backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc','#ff4c8c','#1fddca'],
          hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
          hoverBorderColor: "rgba(234, 236, 244, 1)",
        }],
      },
      options: {
        maintainAspectRatio: false,
        tooltips: {
          backgroundColor: "rgb(255,255,255)",
          bodyFontColor: "#858796",
          borderColor: '#dddfeb',
          borderWidth: 1,
          xPadding: 15,
          yPadding: 15,
          displayColors: false,
          caretPadding: 10,
        },
        legend: {
          display: false
        },
        cutoutPercentage: 80,
      },
    });
  }
  // Pie Chart Example
  
});