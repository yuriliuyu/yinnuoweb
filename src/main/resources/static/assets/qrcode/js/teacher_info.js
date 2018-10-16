/**
 * Created by Feil.Wang on 2015/4/9.
 */

var API_HOST = 'http://121.41.106.37:8080';
var Util = {
    getUrlParam: function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }
};
var token = Util.getUrlParam('token');
var teacherId = Util.getUrlParam('teacherId');

$(function () {
    FastClick.attach(document.body);
    /*$.ajax({
        type: 'get',
        dataType: 'jsonp',
        url: API_HOST + '/teacher/api/user/getTeacherById',
        data: {
            token: token,
            teacherId: teacherId
        },
        success: function (data) {
            if (data.success) {
                renderHTML(data.data);
            }
        }
    });*/
    var data = {
        "data": {
            "subjects": "全学科",
            "avatarUrl": null,
            "name": "孝全文化",
            "teacherIdentify": 1,
            "courseYear": null,
            "star": 5,
            "gender": null,
            "selfDescription": '　　云南孝全文化传播有限公司成立于1997年,前身是云南强林文化传播有限公司。公司本着“服务教育、方便教学”的宗旨，长期专著于基础教育考试的研究，并在云南、贵州、山东、江苏、江西等地建立了研发基地。目前公司已经网罗多位省内外享有盛誉的初、高中一线把关教师和50余名具有大学本科以上学历的专职人员从事教学考试资料的研究、开发、制作等工作，同时集研发、生产、销售、物流一体化，建立了全面、科学、便捷的“一条龙”服务体系。<br>　　公司与云南师大附中合作研制的《云南师大附中高考适应性月考卷》、与贵阳第一中学合作研制的《贵阳一中高考适应性月考卷》、与昆明市第八中学合作研制的《昆八中高一、高二教学测评月考卷》、与昆明市第十中学及昭通一中凤池中学等学校合作研制的《云南省（昆明市）初中学业水平考试适应性月考卷》等试卷产品深受广大师生的欢迎。除了研发试卷，公司还研发各类高中、初中教辅图书，如：《学乐时空——高中同步系列》、《学乐时空——高中学业水平考试指导书卷》、《考乐时空——高中学业水平考试解读金卷》、《考乐时空——高考仿真金卷》、《考乐时空——初中学业水平考试复习指南》《考乐时空——初中学业水平考试解读卷》等。除了以上研发工作，我们为客户专门制作符合自身需要的个性化产品，如学校期中期末考试卷、单位内部资料性出版物等。<br>　　云南孝全文化传播有限公司将与合作单位一道，继续做中学最实用的教辅图书，开发有利于“减负、提质、增效”的教考资料，努力为广大学校师生做好服务工作。',
            "grades": "初中、高中",
            "teacherId": "015280d2-a27e-4e71-b0d1-d5cd4d2c3dcb"
        },
        "success": true
    };
    renderHTML(data.data);
});

function renderHTML(data) {
    var profile = data;
    if (profile.avatarUrl) {
        $('#avatar').attr('src', profile.avatarUrl);
    } else {
        $('#avatar').attr('src', 'images/default-avatar@2x.png');
    }
    //姓名
    $('title,#name').text(profile.name);
    //性别
    if (profile.gender == 2) {
        $('#sex').addClass('icon-female');
    } else if (profile.gender == 1) {
        $('#sex').addClass('icon-male');
    } else {
        $('#sex').addClass('icon-male');
    }
    //身份鉴定
    var indentify = {1: '专职教师', 2: '在校学生'};
    $('#teacherIdentify').text(indentify[profile.teacherIdentify]);
    //星级
    $('#star').addClass('star-level-' + profile.star);
    //辅导学科
    $('#subject').text(profile.subjects);
    //辅导年级
    $('#grades').text(profile.grades);
    //教龄
    $('#courseYear').text(profile.courseYear);
    //个人介绍
    $('#selfDescription').html(profile.selfDescription);
}