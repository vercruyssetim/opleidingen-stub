import angular from 'angular';
import HelloWorldResource from './hello-world-resource-service';
import HelloWorldCtrl from './hello-world-controller';

const dependencies = [];

export default angular
    .module('ai.ui.helloWorld', dependencies)
    .controller('HelloWorldCtrl', HelloWorldCtrl)
    .service('helloWorldResource', HelloWorldResource);
