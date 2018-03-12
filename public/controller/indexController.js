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
		$http.get('/pessoaController/listAllPessoas').
		success(function(responseData) {
			$scope.pessoaList = responseData;
		});
	}
	
	$scope.abrirModalAddPessoa = function() {
		var modalInstance = $modal.open({
            templateUrl: 'adicionarPessoaModal',
            controller: controlerAdicionarPessoa,
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
            templateUrl: 'editaPessoaModal',
            controller: controlerEditarPessoa,
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
            templateUrl: 'deletarPessoaModal',
            controller: controlerDeletarPessoa,
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




let controlerAdicionarPessoa = function ($scope, $modalInstance, $http, $timeout, $sce) {
	var objPessoa = {};
	$scope.ufList = [];
	$http.get('http://www.geonames.org/childrenJSON?geonameId=3469034')
	.success(function(responseData) {
		$scope.ufList = responseData;
	});
	
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


let controlerEditarPessoa = function ($scope, $modalInstance, $http, $timeout, $sce, pessoaParametro) {
	$scope.ufList = [];
	$scope.pessoa = {};
	$scope.parseInt = parseInt;
	
	
	$http.get('http://www.geonames.org/childrenJSON?geonameId=3469034')
	.success(function(responseData) {
		$scope.ufList = responseData;
	});
	$scope.pessoa = pessoaParametro;
	
	if ($scope.pessoa.peso == undefined) {
		$scope.pessoa.peso = 0;
	}
	
	if ($scope.pessoa.uf == undefined) {
		$scope.pessoa.uf = '';
	}
	 
	$scope.pessoa.dia = parseInt($scope.pessoa.dataNascimento.substring(0,2));
	$scope.pessoa.mes = parseInt($scope.pessoa.dataNascimento.substring(3,5));
	$scope.pessoa.ano = parseInt($scope.pessoa.dataNascimento.substring(6,10));
	
	$scope.editarPessoa = function() {
		if ($scope.pessoa.peso == undefined) {
			$scope.pessoa.peso = 0;
		}
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

let controlerDeletarPessoa = function ($scope, $modalInstance, $http, $timeout, $sce, cpfParametro) {
	$scope.deletarPessoa = function(){
		$http.get('/pessoaController/deletarPessoa/'+cpfParametro).then(function(response) {
				$modalInstance.close(response);
		});
	}
	
	$scope.fechar = function() {
		$modalInstance.dismiss();
	};
};
