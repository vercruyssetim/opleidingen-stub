import menuTemplate from './navigation/menu.html!text';
import helloWorldTemplate from './hello-world/hello-world.html!text';

const RouteProvider = function ($routeProvider) {
    $routeProvider
        .when('/helloWorld', {
            template: helloWorldTemplate,
            controller: 'HelloWorldCtrl',
            controllerAs: 'helloWorld'
        })
        .when('/menu', {
            template: menuTemplate,
            controller: 'MenuCtrl'
        })
        .otherwise({
            redirectTo: '/menu'
        });

};

export default RouteProvider;