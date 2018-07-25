//* OVALOIS * Controller de data table basada en peticiones json

// DOCUMENTATION //
//URL QUERY: /GetData?Action=1 - We  request the json object
//URL QUERY: /GetData?Action=2 - We  request the name of the file
//URL QUERY: /GetData?Action=3 - We  request the file for download

angular.module('reporter', ['dataGrid', 'pagination', 'ngMaterial'])
        .controller('datatable', ['$scope', 'App', function ($scope, App, $location, $http) {
                $scope.loader = !$scope.loader;
                $scope.state = false;
                $scope.showfilelist = function () {
                  
                }
                $scope.DataT = {
                    data: [],
                    urlSync: false
                };
                App.getData().then(function (responseData) {
                    $scope.DataT.data = responseData.data;
                    $scope.loader = false;
                    $scope.state = !$scope.state;
                })
            }])
        .factory('App', function ($http, $location) {
            var path = $location.absUrl() + "/GetData?Action=1";
            return {
                getData: function () {
                    return $http({
                        method: 'GET',
                        url: path
                    });
                }
            }
        });

       