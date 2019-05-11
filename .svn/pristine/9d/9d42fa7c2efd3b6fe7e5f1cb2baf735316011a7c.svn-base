// Copyright (c) 2009 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

/**
 * @fileoverview CFInstall.js provides a set of utilities for managing the
 *               Chrome Frame detection and installation process.
 * @author slightlyoff@google.com (Alex Russell)
 */

(function(scope) {
	// bail if we'd be over-writing an existing CFInstall object
	if (scope['CFInstall']) {
		return;
	}

	// ///////////////////////////////////////////////////////////////////////////
	// Plugin Detection
	// ///////////////////////////////////////////////////////////////////////////

	/**
	 * Checks to find out if ChromeFrame is available as a plugin
	 * 
	 * @return {Boolean}
	 */
	var isAvailable = function() {
		// For testing purposes.
		if (scope.CFInstall._force) {
			return scope.CFInstall._forceValue;
		}

		// Look for CF in the User Agent before trying more expensive checks
		var ua = navigator.userAgent.toLowerCase();
		if (ua.indexOf("chromeframe") >= 0) {
			return true;
		}

		if (typeof window['ActiveXObject'] != 'undefined') {
			try {
				var obj = new ActiveXObject('ChromeTab.ChromeFrame');
				if (obj) {
					obj.registerBhoIfNeeded();
					return true;
				}
			} catch (e) {
				// squelch
			}
		}
		return false;
	};

	/** @type {boolean} */
	var cfStyleTagInjected = false;
	/** @type {boolean} */
	var cfHiddenInjected = false;

	/**
	 * Injects style rules into the document to handle formatting of Chrome
	 * Frame prompt. Multiple calls have no effect.
	 */
	var injectCFStyleTag = function(text) {
		if (cfStyleTagInjected) {
			// Once and only once
			return;
		}
		var b = document.body;
		var el = document.createElement('iframe');
		el.style.display = 'none';
		b.appendChild(el);

		var tbl = document.createElement('table');
		tbl.setAttribute('border', 0);
		tbl.style.border = '0px';
		tbl.style.width = '100%';
		tbl.style.backgroundColor = 'rgb(244, 241, 202)';
		tbl.style.lineHeight = '20px';
		tbl.style.top = '0px';
		tbl.style.position = 'fixed';

		var tr = tbl.insertRow();
		tr.style.cursor = 'pointer';

		var td = tr.insertCell(0);
		td.innerHTML = '&times;';
		td.style.width = '1px';
		td.style.fontSize = '20px';
		td.onclick = function() {
			if (cfHiddenInjected) {
				return;
			}
			tbl.style.display = 'none';
			// Hide the dialog for a year (or until cookies are deleted).
			var age = 365 * 24 * 60 * 60 * 1000;
			document.cookie = "disableGCFCheck=1;path=/;max-age=" + age;
			cfHiddenInjected = true;
		};

		var td = tr.insertCell(0);
		td.innerHTML = text || '\u8c37\u6b4c\u6d4f\u89c8\u5668\u5185\u5d4c\u6846\u67b6\u53ea\u9002\u7528\u4e8e Windows 7/Vista/XP SP2 \u6216\u66f4\u9ad8\u7248\u672c\u7cfb\u7edf\u4e0a\u7684 Internet Explorer 6\u30017\u30018 \u548c 9\u3002';
		td.title = '\u70b9\u51fb\u5b89\u88c5';
		td.onclick = function() {
			var installUrl = (typeof _application_root == 'undefined' ? '' : _application_root + '/') + 'templets/ui/CFInstall.jsp';// protocol
			el.src = installUrl;
			tbl.style.display = 'none';
		};
		b.insertBefore(tbl, b.firstChild);

		cfStyleTagInjected = true;
	};

	var CFInstall = {};

	/**
	 * Checks to see if Chrome Frame is available, if not, prompts the user to
	 * install. Once installation is begun, a background timer starts,
	 * checkinging for a successful install every 2 seconds. Upon detection of
	 * successful installation, the current page is reloaded, or if a
	 * 'destination' parameter is passed, the page navigates there instead.
	 * 
	 * @param {Object}
	 *            args A bag of configuration properties. Respected properties
	 *            are: 'mode', 'url', 'destination', 'node', 'onmissing',
	 *            'preventPrompt', 'oninstall', 'preventInstallDetection',
	 *            'cssText', and 'className'.
	 * @public
	 */
	CFInstall.check = function(args) {
		args = args || {};

		// We currently only support CF in IE
		var ua = navigator.userAgent;
		var ieRe = /MSIE (\S+); Windows NT/;
		var bail = false;
		if (ieRe.test(ua)) {
			// We also only support Win2003/XPSP2 or better. See:
			// http://msdn.microsoft.com/en-us/library/ms537503%28VS.85%29.aspx
			var msie = parseFloat(ieRe.exec(ua)[1]);
			var win7 = ua.indexOf("Windows NT 6.1") > -1 || ua.indexOf("Windows 7") > -1;
			if (win7 && msie >= 8) {
				bail = true;
			}
			if (msie < 6 &&
			// 'SV1' indicates SP2, only bail if not SP2 or Win2K3
			ua.indexOf('SV1') < 0) {
				bail = true;
			}
		} else {
			// Not IE
			bail = true;
		}
		if (bail) {
			return;
		}

		if (!isAvailable()) { 
			if (document.cookie.indexOf("disableGCFCheck=1") >= 0 && args.remeber) {
				return;
			}
			injectCFStyleTag();
		}
	};

	CFInstall._force = false;
	CFInstall._forceValue = false;
	CFInstall.isAvailable = isAvailable;

	// expose CFInstall to the external scope. We've already checked to make
	// sure we're not going to blow existing objects away.
	scope.CFInstall = CFInstall;

})(this['ChromeFrameInstallScope'] || this);