import gulp from "gulp";
import runSequence from "run-sequence";
import del from "del";
import rename from "gulp-rename";
import replace from "gulp-replace";
import {files, env} from "../config";
import {argv} from "../argv";

const environment = (argv.env) ? argv.env : 'LOCAL';
const version = (argv.version) ? argv.version : '0.0.0';

export const cleanConfigXmlOrig = 'clean:configXmlOrig';
export const cleanConfigXml = 'clean:configXml';
export const copyConfigXmlToOrig = 'copy:configXmlToOrig';
export const prepareConfigXmlReplace = 'prepare:configXmlReplace';
export const configXml = 'configXml';

const replaceConfigurationsInConfigXml = env =>
    gulp.src([files.configXmlOrig])
        .pipe(replace(/id="[^"]*"/, `id="${env.appId}"`))
        .pipe(replace(/<widget (.*) version="[\d\.]*"/, `<widget $1 version="${version}"`))
        .pipe(replace(/<name>.*<\/name>/, `<name>${env.appName}<\/name>`))
        .pipe(rename(files.configXml))
        .pipe(gulp.dest(''));

gulp.task(configXml, [prepareConfigXmlReplace], () =>
    replaceConfigurationsInConfigXml(env[environment])
);

gulp.task(prepareConfigXmlReplace, callback =>
    runSequence(
        cleanConfigXmlOrig,
        copyConfigXmlToOrig,
        cleanConfigXml,
        callback)
);

gulp.task(cleanConfigXmlOrig, () =>
    del(files.configXmlOrig)
);

gulp.task(cleanConfigXml, () =>
    del(files.configXml)
);

gulp.task(copyConfigXmlToOrig, () =>
    gulp.src(files.configXml)
        .pipe(rename(files.configXmlOrig))
        .pipe(gulp.dest(''))
);
