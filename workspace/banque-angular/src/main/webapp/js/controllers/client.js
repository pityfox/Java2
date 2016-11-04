(function() {
	var app = angular.module("client", []);
	
	app.controller("ClientController", function($http) {
		var self = this;
		
		self.clients = [];
		
		self.client = null;
		self.civilites = [];
		
		self.list = function() {
			$http({
				method : 'GET',
				url : 'services/client/'
			}).then(function successCallback(response) {
				self.clients = response.data;
			}, function errorCallback(response) {

			});
		};
		
		self.add = function() {
			self.client={};
			
		}; 
		
		self.save = function() {
			if(self.client.id) {
				$http({
					method : 'PUT',
					url : 'services/client/' + self.client.id,
					data : self.client
				}).then(function successCallback(response) {
					self.list();
					self.client=null;
				}, function errorCallback(response) {
	
				});
			} else {
				$http({
					method : 'POST',
					url : 'services/client/',
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
				self.client.dtNaissance = new Date(self.client.dtNaissance);
			}, function errorCallback(response) {

			});
			
			$http({
				method : 'GET',
				url : 'services/civilites/'
			}).then(function successCallback(response) {
				self.civilites = response.data;
				console.log(self.civilites);
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
})(); 