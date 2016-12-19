// Karma configuration
// http://karma-runner.github.io/0.12/config/configuration-file.html
// Generated on 2014-11-17 using
// generator-karma 0.8.3

/* global module */

module.exports = function (config) {
    'use strict';

    config.set({
        // base path, that will be used to resolve files and exclude
        basePath: '../',

        // enable / disable watching file and executing tests whenever any file changes
        autoWatch: false,
        colors: true,

        // level of logging
        // possible values: LOG_DISABLE || LOG_ERROR || LOG_WARN || LOG_INFO || LOG_DEBUG
        logLevel: config.LOG_INFO,

        // testing framework to use (jasmine/mocha/qunit/...)
        frameworks: ['jspm', 'jasmine'],

        // list of files / patterns to load in the browser
        files: [
            'node_modules/babel-polyfill/dist/polyfill.js'
        ],

        // list of files / patterns to exclude
        exclude: [],

        browserNoActivityTimeout: 600000,

        // Which plugins to enable
        plugins: [
            'karma-jspm',
            // 'karma-chrome-launcher',
            // 'karma-firefox-launcher',
            'karma-phantomjs-launcher',
            'karma-jasmine',
            'karma-babel-preprocessor',
            //'karma-coverage',
            'karma-junit-reporter'
        ],

        jspm: {
            config: 'src/config.js',
            loadFiles: [
                'src/jspm_packages/github/angular/bower-angular-mocks@1.5.8/angular-mocks.js',
                'src/jspm_packages/github/bverbist/bower-angular-ice@0.8.0/angular-ice.unitTester.js',
                'src/app/app.js',
                'src/app/**/*_test.js'
            ],
            serveFiles: [
                'src/app/**/!(*_test).js',
                'src/**/*.html',
                'src/**/*.css',
                'src/**/*.json'
            ],
            // Ben: paths override and proxies were necessary to get karma-jspm to work (otherwise 404 errors when getting src or jspm_packages files)
            //      see also https://github.com/Workiva/karma-jspm/issues/91
            paths: {
                'github:*': '/src/jspm_packages/github/*',
                'npm:*': '/src/jspm_packages/npm/*'
            }
        },

        proxies: {
            '/src/': '/base/src/',
            '/jspm_packages/': '/src/jspm_packages/'
        },

        preprocessors: {
            'src/app/**/*.js': ['babel']
        },

        babelPreprocessor: {
            options: {
                sourceMap: 'inline',
                retainLines: true
            }
        },

        reporters: ['dots', 'junit'],
        junitReporter: {
            outputFile: '../test-reports/karma/test-results_karma.xml'
        },
        // Start these browsers, currently available:
        // - Chrome
        // - ChromeCanary
        // - Firefox
        // - Opera
        // - Safari (only Mac)
        // - PhantomJS
        // - IE (only Windows)
        browsers: [
            'PhantomJS'
        ]
    });
};
