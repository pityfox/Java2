(function() {
	var app = angular.module("agence", []);
	
	app.controller("AgenceController", function($http) {
		var self = this;
		self.mode= "";
		self.agences = [];
		
		self.agence = null;
		
		self.list = function() {
			$http({
				method : 'GET',
				url : 'services/agence/'
			}).then(function successCallback(response) {
				self.agences = response.data;
			}, function errorCallback(response) {

			});
		};
		
		self.add = function() {
			self.agence={};
			self.mode="new";
		}; 
		
		self.save = function() {
			if(self.mode == "edit") {
				$http({
					method : 'PUT',
					url : 'services/agence/' + self.agence.id.numAgence + ':' + self.agence.id.numBanque,
					data : self.agence
				}).then(function successCallback(response) {
					self.list();
					self.agence=null;
				}, function errorCallback(response) {
	
				});
			} else {
				$http({
					method : 'POST',
					url : 'services/agence/',
					data : self.agence
				}).then(function successCallback(response) {
					self.list();
					self.agence=null;
				}, function errorCallback(response) {
	
				});
			}
			
			
		}; 
		
		self.edit = function(numAgence, numBanque) {
			self.mode="edit";
			$http({
				method : 'GET',
				url : 'services/agence/' + numAgence + ":" + numBanque
			}).then(function successCallback(response) {
				self.agence = response.data;
			}, function errorCallback(response) {

			});
			
		}; 
		
		self.remove = function(numAgence, numBanque) {
			$http({
				method : 'DELETE',
				url : 'services/agence/' + numAgence + ":" + numBanque
			}).then(function successCallback(response) {
				self.list();
			}, function errorCallback(response) {

			});
		}; 
		
		self.list();
	});
	
	app.directive("agence", function(){
		return {
			restrict: 'E',
			templateUrl: "agence.html",
			controller: 'AgenceController',
			controllerAs: 'agenceCtrl'
		};
	});
})(); 