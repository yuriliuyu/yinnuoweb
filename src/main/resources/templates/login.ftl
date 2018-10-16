<!DOCTYPE html>
<html>
<head>
<#include "inc/header.ftl">
</head>
<body class="page-body login-page login-light">
<div class="login-container">
    <div class="row">
        <div class="col-sm-6">
            <script type="text/javascript">
                jQuery(document).ready(function ($) {
                    // Reveal Login form
                    setTimeout(function () {
                        $(".fade-in-effect").addClass('in');
                    }, 1);


                    // Validation and Ajax action
                    $("form#login").validate({
                        rules: {
                            username: {
                                required: true
                            },
                            passwd: {
                                required: true
                            }
                        },

                        messages: {
                            username: {
                                required: '请输入用户名'
                            },

                            passwd: {
                                required: '请输入密码'
                            }
                        },

                        // Form Processing via AJAX
                        submitHandler: function (form) {
                            show_loading_bar(70); // Fill progress bar to 70% (just a given value)

                            var opts = {
                                "closeButton": true,
                                "debug": false,
                                "positionClass": "toast-top-full-width",
                                "onclick": null,
                                "showDuration": "300",
                                "hideDuration": "1000",
                                "timeOut": "5000",
                                "extendedTimeOut": "1000",
                                "showEasing": "swing",
                                "hideEasing": "linear",
                                "showMethod": "fadeIn",
                                "hideMethod": "fadeOut"
                            };

                            $.ajax({
                                url: WEB_SERVER + "web/loginVerify",
                                method: 'POST',
                                dataType: 'json',
                                data: {
                                    userAccount: $(form).find('#username').val(),
                                    password: $(form).find('#passwd').val(),
                                },
                                success: function (resp) {
                                    show_loading_bar({
                                        delay: .5,
                                        pct: 100,
                                        finish: function () {
                                            console.log(resp);
                                            if (resp.code == 1) {
                                                console.log('userAccount=' + resp.data['userAccount']);
                                                $.cookie("userAccount", resp.data['userAccount'],{ path:'/', expires: 7 });
                                                window.location.href = WEB_SERVER +'web/index';
                                            }else{
                                                $("#vcode").click();
                                                // Remove any alert
                                                $(".errors-container .alert").slideUp('fast');

                                                // Show errors
                                                $(".errors-container").html('<div class="alert alert-danger">\
                                                    <button type="button" class="close" data-dismiss="alert">\
                                                        <span aria-hidden="true">&times;</span>\
                                                        <span class="sr-only">Close</span>\
                                                    </button>\
                                                    ' + resp.message + '\
											    </div>');


                                            }

                                        }
                                    });


                                }
                            });

                        }
                    });
                });
            </script>
            <!-- Errors container -->
            <div class="errors-container">
            </div>
            <!-- Add class "fade-in-effect" for login form effect -->
            <form method="post" role="form" id="login" class="login-form fade-in-effect">
                <div class="login-header">
                    <h1>茵诺医疗管理系统</h1>
                </div>
                <div class="form-group">
                    <label class="control-label" for="username">用户名</label>
                    <input type="text" class="form-control" name="username" id="username" autocomplete="off"/>
                </div>
                <div class="form-group">
                    <label class="control-label" for="passwd">密码</label>
                    <input type="password" class="form-control" name="passwd" id="passwd" autocomplete="off"/>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary  btn-block text-center">
                        <i class="fa-lock"></i>
                        登录
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>