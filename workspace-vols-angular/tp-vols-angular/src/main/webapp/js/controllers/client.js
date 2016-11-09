(function() {
	var app = angular.module("client", []);
	
	app.controller("ClientController", function($http) {
		var self = this;
		
		self.clients = [];
		self.client = null;
		
		self.titres = [];
		
		self.list = function() {
			$http({
				method : 'GET',
				url : 'services/client/'
			}).then(function successCallback(response) {
				self.clients = response.data;
			}, function errorCallback(response) {

			});
		};
		
		self.addClientPhysique = function() {
			self.client={type:'Physique'};
			
			$http({
				method : 'GET',
				url : 'services/titres/Physique'
			}).then(function successCallback(response) {
				self.titres = response.data;
				console.log(self.titres);
			}, function errorCallback(response) {

			});
		}; 
		
		self.addClientMoral = function() {
			self.client={type:'Moral'};
			
			$http({
				method : 'GET',
				url : 'services/titres/Moral'
			}).then(function successCallback(response) {
				self.titres = response.data;
				console.log(self.titres);
			}, function errorCallback(response) {

			});
		}; 
		
		self.addClientEI = function() {
			self.client={type:'EI'};
			
			$http({
				method : 'GET',
				url : 'services/titres/Physique'
			}).then(function successCallback(response) {
				self.titres = response.data;
				console.log(self.titres);
			}, function errorCallback(response) {

			});
		}; 
		
		self.save = function() {
			if(self.client.id) {
				$http({
					method : 'PUT',
					url : 'services/client/' + self.client.type + '/' + self.client.id,
					data : self.client
				}).then(function successCallback(response) {
					self.list();
					self.client=null;
				}, function errorCallback(response) {
	
				});
			} else {
				$http({
					method : 'POST',
					url : 'services/client/' + self.client.type + '/',
					data : self.client
				}).then(function successCallback(response) {
					self.list();
					self.client=null;
				}, function errorCallback(response) {
	
				});
			}
			
			
		}; 
		
		self.edit = function(id) {
			
			$http({
				method : 'GET',
				url : 'services/client/' + id 
			}).then(function successCallback(response) {
				self.client = response.data;
				$http({
					method : 'GET',
					url : 'services/titres/' + self.client.type
				}).then(function successCallback(response) {
					self.titres = response.data;
					console.log(self.titres);
				}, function errorCallback(response) {

				});
			}, function errorCallback(response) {

			});
			
			
			
		}; 
		
		self.remove = function(id) {
			$http({
				method : 'DELETE',
				url : 'services/client/' + id
			}).then(function successCallback(response) {
				self.list();
			}, function errorCallback(response) {

			});
		}; 
		
		self.list();
	});
	
	app.directive("client", function(){
		return {
			restrict: 'E',
			templateUrl: "client.html",
			controller: 'ClientController',
			controllerAs: 'clientCtrl'
		};
	});
})(); 