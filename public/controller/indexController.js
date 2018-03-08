var moduleIndexVar = angular.module('moduleIndex', ['ui.bootstrap', 'ngRoute', 'ngCookies', 'angular-md5']);

moduleIndexVar.directive('directiveEditarPessoa', function() {
    return {
        templateUrl : 'assets/directives/directiveEditarPessoa.html'
    };
});

moduleIndexVar.directive('directiveAdicionarPessoa', function() {
    return {
        templateUrl : 'assets/directives/directiveAdicionarPessoa.html'
    };
});

moduleIndexVar.directive('directiveDeletarPessoa', function() {
    return {
        templateUrl : 'assets/directives/directiveDeletarPessoa.html'
    };
});


moduleIndexVar.controller('indexController', ['$rootScope', '$scope', '$http', '$modal', '$timeout', '$window', '$cookies', '$location', 'md5',
                                              function($rootScope, $scope, $http, $modal, $timeout, $window, $cookies, $location, md5) {

	$scope.pessoaList = [];
	findTabelaPessoas();
	
	function findTabelaPessoas() {
		$http.get('/pessoaController/findAllPessoas').
		success(function(responseData) {
			$scope.pessoaList = responseData;
		});
	}
	
	$scope.abrirModalAddPessoa = function() {
		var modalInstance = $modal.open({
            templateUrl: 'idModalAdicionarPessoa',
            controller: modalControlerAdicionarPessoa,
            size: 'md',
        });
		
		modalInstance.result.then(function (response) {
			
			$scope.alertaSistemaTemplate.msg = response.data.msg;
        	$scope.alertaSistemaTemplate.tipo = response.data.tipo;
        	$scope.alertaSistemaTemplate.show = true;
        	$scope.alertaSistemaTemplate.icon = response.data.icon;
			$timeout(function() { $scope.alertaSistemaTemplate.show = false; }, 5000);
			findTabelaPessoas();
			
		}, function (parametro) {
	    });
	};
	
	
	$scope.abrirModalEditarPessoa = function(pessoa) {
		var modalInstance = $modal.open({
            templateUrl: 'idModalEditarPessoa',
            controller: modalControlerEditarPessoa,
            size: 'md',
            resolve: {
	        	pessoaParametro: function () {
	        		return pessoa;
	        	}
	        }
	    });


		modalInstance.result.then(function (response) {
			$scope.alertaSistemaTemplate.msg = response.data.msg;
        	$scope.alertaSistemaTemplate.tipo = response.data.tipo;
        	$scope.alertaSistemaTemplate.show = true;
        	$scope.alertaSistemaTemplate.icon = response.data.icon;
			$timeout(function() { $scope.alertaSistemaTemplate.show = false; }, 5000)
			findTabelaPessoas();
		},function (parametro) {
	    });
	};

	
	$scope.abrirModalDelatarPessoa = function(cpf) {
		var modalInstance = $modal.open({
            templateUrl: 'idAlertaDeletarPessoa',
            controller: modalControlerDeletarPessoa,
            size: 'md',
            resolve: {
                cpfParametro: function () {
                    return cpf;
                }

            }
        });
		modalInstance.result.then(function (response) {
			$scope.alertaSistemaTemplate.msg = response.data.msg;
        	$scope.alertaSistemaTemplate.tipo = response.data.tipo;
        	$scope.alertaSistemaTemplate.show = true;
        	$scope.alertaSistemaTemplate.icon = response.data.icon;
			$timeout(function() { $scope.alertaSistemaTemplate.show = false; }, 5000);
			findTabelaPessoas();
		},function (parametro) {
	    });
	};
}]);




var modalControlerAdicionarPessoa = function ($scope, $modalInstance, $http, $timeout, $sce) {
	$scope.ufList = [];
	$http.get('http://www.geonames.org/childrenJSON?geonameId=3469034')
	.success(function(responseData) {
		$scope.ufList = responseData;
	});
	
	var objPessoa = {};
	$scope.adicionarPessoa = function(){
		let cpf = $scope.cpf;
		let nome = $scope.nome;
		let dia = $scope.dia;
		let mes = $scope.mes;
		let ano = $scope.ano;
		let uf;
		let peso;
		
		if ($scope.peso != undefined) {
			peso = $scope.peso;
			objPessoa.peso = peso;
		} else {
			objPessoa.peso = 0;
		}
		
		if ($scope.uf != undefined) {
			uf = $scope.uf.id;
			objPessoa.uf = uf;
		} else {
			objPessoa.uf = '';
		}
		
		objPessoa.cpf = cpf;
		objPessoa.nome = nome;
		objPessoa.dia = dia;
		objPessoa.mes = mes;
		objPessoa.ano = ano;
		
		
		$http.post('/pessoaController/cadastrarPessoa',
				objPessoa).then(function(response) {
					$modalInstance.close(response);
		});
	}
	$scope.fechar = function() {
		$modalInstance.dismiss();
	};
};


var modalControlerEditarPessoa = function ($scope, $modalInstance, $http, $timeout, $sce, pessoaParametro) {
	$scope.ufList = [];
	$http.get('http://www.geonames.org/childrenJSON?geonameId=3469034')
	.success(function(responseData) {
		$scope.ufList = responseData;
	});
	
	$scope.pessoa = {};
	$http.get('http://www.geonames.org/childrenJSON?geonameId=3469034')
	.success(function(responseData) {
		$scope.ufList = responseData;
	});
	$scope.pessoa = pessoaParametro;
	$scope.editarPessoa = function() {
		uf = $scope.pessoa.uf;
		pessoa.uf = uf;
		$http.post('/pessoaController/editarPessoa', $scope.pessoa).then(function(response) {
			$modalInstance.close(response);
		});
	};

	$scope.fechar = function() {
		$modalInstance.dismiss();
	};
};

var modalControlerDeletarPessoa = function ($scope, $modalInstance, $http, $timeout, $sce, cpfParametro) {
	$scope.deletarPessoa = function(){
		$http.get('/pessoaController/deletarPessoa/'+cpfParametro).then(function(response) {
				$modalInstance.close(response);
		});
	}
	
	$scope.fechar = function() {
		$modalInstance.dismiss();
	};
};
