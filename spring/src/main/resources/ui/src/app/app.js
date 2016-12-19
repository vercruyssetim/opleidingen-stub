import angular from 'angular';
import 'angular-route';
import 'angular-bootstrap/ui-bootstrap-tpls.js';
import '../assets/css/bootstrap.css!css';
import RouteProvider from './route-provider';
import navigationModule from './navigation/navigation-module';
import helloWorldModule from './hello-world/hello-world-module';
import configModule from './config/config-module';

const dependencies = [
    navigationModule.name,
    helloWorldModule.name,
    configModule.name,
    'ui.bootstrap',
    'ngRoute'
];

angular
    .module('ai.ui', dependencies)
    .config(RouteProvider);