import gulp from "gulp";
import httpProxy from "http-proxy-middleware";
import browserSync from "browser-sync";
import {dirs, fileNames, files, proxy} from "../config";

export const browserSyncServer = browserSync.create();

export const serve = 'serve';

gulp.task(serve, callback => {
    let options = {
        port: 8100,
        ui: {
            port: 8101
        },
        server: {
            baseDir: dirs.src,
            index: fileNames.indexHtml
        },
        files: [
            files.html,
            files.css,
            files.js
        ]
    };

    if (proxy.context !== '') {
        let middleware = httpProxy(proxy.context, proxy.options);
        options.server.middleware = [middleware];
    }

    browserSyncServer.init(
        options,
        callback);
});
