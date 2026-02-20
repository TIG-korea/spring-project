/* ============================================================
   Q-Box — app.js
   Minimal interactions: nav toggle, dark mode, password toggle,
   toast dismiss, lightweight form validation.
   ============================================================ */

(function () {
  'use strict';

  /* ────────────────────────────────────────────────────────────
     1. Dark Mode Toggle
     ──────────────────────────────────────────────────────────── */
  const THEME_KEY = 'qbox-theme';

  function getPreferredTheme() {
    var stored = localStorage.getItem(THEME_KEY);
    if (stored) return stored;
    return window.matchMedia('(prefers-color-scheme: dark)').matches
      ? 'dark'
      : 'light';
  }

  function applyTheme(theme) {
    document.documentElement.setAttribute('data-theme', theme);
    localStorage.setItem(THEME_KEY, theme);
  }

  // Apply theme immediately (before DOMContentLoaded to avoid flash)
  applyTheme(getPreferredTheme());

  document.addEventListener('DOMContentLoaded', function () {
    var themeButtons = document.querySelectorAll('.theme-toggle');
    themeButtons.forEach(function (btn) {
      btn.addEventListener('click', function () {
        var current = document.documentElement.getAttribute('data-theme');
        applyTheme(current === 'dark' ? 'light' : 'dark');
      });
    });

    /* ────────────────────────────────────────────────────────────
       2. Mobile Navigation Toggle
       ──────────────────────────────────────────────────────────── */
    var menuBtn = document.querySelector('.mobile-menu-btn');
    var mobileNav = document.querySelector('.nav-mobile');

    if (menuBtn && mobileNav) {
      menuBtn.addEventListener('click', function () {
        var expanded = menuBtn.getAttribute('aria-expanded') === 'true';
        menuBtn.setAttribute('aria-expanded', String(!expanded));
        mobileNav.classList.toggle('open');

        if (!expanded) {
          // Focus first link when opening
          var firstLink = mobileNav.querySelector('.nav-link');
          if (firstLink) firstLink.focus();
        }
      });

      // Close on Escape key
      document.addEventListener('keydown', function (e) {
        if (e.key === 'Escape' && mobileNav.classList.contains('open')) {
          menuBtn.setAttribute('aria-expanded', 'false');
          mobileNav.classList.remove('open');
          menuBtn.focus();
        }
      });

      // Close when clicking outside
      document.addEventListener('click', function (e) {
        if (
          mobileNav.classList.contains('open') &&
          !mobileNav.contains(e.target) &&
          !menuBtn.contains(e.target)
        ) {
          menuBtn.setAttribute('aria-expanded', 'false');
          mobileNav.classList.remove('open');
        }
      });
    }

    /* ────────────────────────────────────────────────────────────
       3. Password Visibility Toggle
       ──────────────────────────────────────────────────────────── */
    document.querySelectorAll('.password-toggle').forEach(function (btn) {
      btn.addEventListener('click', function () {
        var wrapper = btn.closest('.password-wrapper');
        var input = wrapper ? wrapper.querySelector('input') : null;
        if (!input) return;

        var isPassword = input.getAttribute('type') === 'password';
        input.setAttribute('type', isPassword ? 'text' : 'password');
        btn.setAttribute(
          'aria-label',
          isPassword ? '비밀번호 숨기기' : '비밀번호 보기'
        );

        // Toggle icon visibility
        var iconShow = btn.querySelector('.icon-eye');
        var iconHide = btn.querySelector('.icon-eye-off');
        if (iconShow && iconHide) {
          iconShow.style.display = isPassword ? 'none' : 'block';
          iconHide.style.display = isPassword ? 'block' : 'none';
        }
      });
    });

    /* ────────────────────────────────────────────────────────────
       4. Alert / Toast Close
       ──────────────────────────────────────────────────────────── */
    document.querySelectorAll('.alert-close').forEach(function (btn) {
      btn.addEventListener('click', function () {
        var alert = btn.closest('.alert');
        if (!alert) return;
        alert.classList.add('hiding');
        setTimeout(function () {
          alert.remove();
        }, 250);
      });
    });

    /* ────────────────────────────────────────────────────────────
       5. Lightweight Form Validation
       ──────────────────────────────────────────────────────────── */
    document.querySelectorAll('form[data-validate]').forEach(function (form) {
      form.setAttribute('novalidate', '');

      form.addEventListener('submit', function (e) {
        var isValid = true;
        // Clear previous errors
        form.querySelectorAll('.form-error').forEach(function (el) {
          el.remove();
        });
        form.querySelectorAll('.error').forEach(function (el) {
          el.classList.remove('error');
        });

        // Check required fields
        form
          .querySelectorAll('[required]')
          .forEach(function (field) {
            var value = field.value.trim();
            if (!value) {
              isValid = false;
              showFieldError(field, '필수 입력 항목입니다.');
            }
          });

        // Check minlength
        form
          .querySelectorAll('[minlength]')
          .forEach(function (field) {
            var value = field.value.trim();
            var min = parseInt(field.getAttribute('minlength'), 10);
            if (value && value.length < min) {
              isValid = false;
              showFieldError(field, '최소 ' + min + '자 이상 입력해 주세요.');
            }
          });

        // Check password confirmation
        var pw = form.querySelector('[data-match]');
        if (pw) {
          var targetId = pw.getAttribute('data-match');
          var target = form.querySelector('#' + targetId);
          if (target && pw.value !== target.value) {
            isValid = false;
            showFieldError(pw, '비밀번호가 일치하지 않습니다.');
          }
        }

        if (!isValid) {
          e.preventDefault();
          // Focus first error field
          var firstError = form.querySelector('.error');
          if (firstError) firstError.focus();
        }
      });
    });

    function showFieldError(field, message) {
      field.classList.add('error');
      var errorEl = document.createElement('p');
      errorEl.className = 'form-error';
      errorEl.setAttribute('role', 'alert');
      errorEl.textContent = message;
      field.parentNode.appendChild(errorEl);
    }
  });
})();
