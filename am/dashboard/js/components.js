angular.module('dashboard2').
  component('menulateral', {
    template: 'Hello, {{$ctrl.user}}!',
    controller: function GreetUserController() {
      this.user = 'world';
    }
  });