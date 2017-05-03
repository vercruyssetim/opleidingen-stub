/* global __dirname  */

export const dirs = {
    css: 'css',
    images: 'images',
    src: 'src',
    dist: '../static/ui',
    fonts: 'fonts',
    conf: 'conf',
    settings: 'settings',
    gulpTasks: 'gulp-tasks'
};

export const paths = {
    stylesheets: `${dirs.src}/assets/stylesheets`,
    css: `${dirs.src}/assets/css`,
    jspmPackages: `${dirs.src}/jspm_packages`,
    app: `${dirs.src}/app`,
    ngConstant: `${dirs.src}/app/config`
};

export const fileNames = {
    indexHtml: 'index.html',
    jsBundled: 'app.bundle.js',
    settings: 'settings.js'
};

export const files = {
    js: `${dirs.src}/app/**/*.js`,
    jsApp: `${dirs.src}/app/**/!(*.spec).js`,
    jsSpecs: `${dirs.src}/app/**/*.spec.js`,
    lessMain: `${paths.stylesheets}/app.less`,
    less: `${paths.stylesheets}/*.less`,
    lessBootstrap: `${paths.jspmPackages}/github/distros/bootstrap-less@3.3.9/bootstrap`,
    lessBootstrapMain: `${paths.jspmPackages}/github/distros/bootstrap-less@3.3.9/bootstrap/bootstrap.less`,
    css: `${paths.css}/*.css`,
    html: `${paths.app}/**/*.html`,
    gulp: 'gulpfile.babel.js',
    karmaConf: `${__dirname}/../${dirs.conf}/karma.conf.js`,
    esLint: `${dirs.conf}/.eslintrc`,
    bundleRoot: `${paths.app}/app.js`,
    indexHtml: `${dirs.src}/${fileNames.indexHtml}`
};

export const fileGroups = {
    cleanAssets: [`${paths.css}/*.*`],
    cleanDist: [`${dirs.dist}/**/*.*`, `!${dirs.dist}/.dummy.txt`]
};

export const proxy = {
    context: '/rest',
    options: {
        target: 'http://localhost:8080'
    }
};
