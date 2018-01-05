<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en-US" class="scheme_original">


<!-- Mirrored from microoffice.themerex.net/home-2/ by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 27 Nov 2017 15:25:16 GMT -->
<!-- Added by HTTrack -->
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<!-- /Added by HTTrack -->
<head>
<title>Dashboard &#8211; Micro Office</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="format-detection" content="telephone=no">

<link rel="profile" href="../gmpg.org/xfn/11.html" />
<link rel='dns-prefetch' href='../fonts.googleapis.com/index.html' />
<link rel='dns-prefetch' href='../s.w.org/index.html' />
<link rel="alternate" type="application/rss+xml"
	title="Micro Office &raquo; Feed" href="../feed/index.html" />
<link rel="alternate" type="application/rss+xml"
	title="Micro Office &raquo; Comments Feed"
	href="../comments/feed/index.html" />
<script type="text/javascript">
			window._wpemojiSettings = {"baseUrl":"https:\/\/s.w.org\/images\/core\/emoji\/2.2.1\/72x72\/","ext":".png","svgUrl":"https:\/\/s.w.org\/images\/core\/emoji\/2.2.1\/svg\/","svgExt":".svg","source":{"concatemoji":"http:\/\/microoffice.themerex.net\/${pageContext.request.contextPath }/assets/css/wp-includes\/js\/wp-emoji-release.min.js?ver=4.7.7"}};
			!function(a,b,c){function d(a){var b,c,d,e,f=String.fromCharCode;if(!k||!k.fillText)return!1;switch(k.clearRect(0,0,j.width,j.height),k.textBaseline="top",k.font="600 32px Arial",a){case"flag":return k.fillText(f(55356,56826,55356,56819),0,0),!(j.toDataURL().length<3e3)&&(k.clearRect(0,0,j.width,j.height),k.fillText(f(55356,57331,65039,8205,55356,57096),0,0),b=j.toDataURL(),k.clearRect(0,0,j.width,j.height),k.fillText(f(55356,57331,55356,57096),0,0),c=j.toDataURL(),b!==c);case"emoji4":return k.fillText(f(55357,56425,55356,57341,8205,55357,56507),0,0),d=j.toDataURL(),k.clearRect(0,0,j.width,j.height),k.fillText(f(55357,56425,55356,57341,55357,56507),0,0),e=j.toDataURL(),d!==e}return!1}function e(a){var c=b.createElement("script");c.src=a,c.defer=c.type="text/javascript",b.getElementsByTagName("head")[0].appendChild(c)}var f,g,h,i,j=b.createElement("canvas"),k=j.getContext&&j.getContext("2d");for(i=Array("flag","emoji4"),c.supports={everything:!0,everythingExceptFlag:!0},h=0;h<i.length;h++)c.supports[i[h]]=d(i[h]),c.supports.everything=c.supports.everything&&c.supports[i[h]],"flag"!==i[h]&&(c.supports.everythingExceptFlag=c.supports.everythingExceptFlag&&c.supports[i[h]]);c.supports.everythingExceptFlag=c.supports.everythingExceptFlag&&!c.supports.flag,c.DOMReady=!1,c.readyCallback=function(){c.DOMReady=!0},c.supports.everything||(g=function(){c.readyCallback()},b.addEventListener?(b.addEventListener("DOMContentLoaded",g,!1),a.addEventListener("load",g,!1)):(a.attachEvent("onload",g),b.attachEvent("onreadystatechange",function(){"complete"===b.readyState&&c.readyCallback()})),f=c.source||{},f.concatemoji?e(f.concatemoji):f.wpemoji&&f.twemoji&&(e(f.twemoji),e(f.wpemoji)))}(window,document,window._wpemojiSettings);
		</script>
<style type="text/css">
img.wp-smiley, img.emoji {
	display: inline !important;
	border: none !important;
	box-shadow: none !important;
	height: 1em !important;
	width: 1em !important;
	margin: 0 .07em !important;
	vertical-align: -0.1em !important;
	background: none !important;
	padding: 0 !important;
}
</style>
<link property="stylesheet" rel='stylesheet'
	href='${pageContext.request.contextPath }/assets/css/dataTables.bootstrap.min.css?ver=4.7.7'/>
<link property="stylesheet" rel='stylesheet'
	href='${pageContext.request.contextPath }/assets/css/bootstrap.min.css?ver=4.7.7'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet' id='timeline-css-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/content_timeline/css/frontend/timeline447e.css?ver=4.7.7'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet' id='customScroll-css-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/content_timeline/css/frontend/jquery.mCustomScrollbar447e.css?ver=4.7.7'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet' id='prettyPhoto-css-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/content_timeline/css/frontend/prettyPhoto447e.css?ver=4.7.7'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='my_timeline_font_awesome-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/content_timeline/css/frontend/awesome/font-awesome447e.css?ver=4.7.7'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='my_timeline_lineicons_css-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/content_timeline/css/frontend/themify-icons447e.css?ver=4.7.7'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet' id='bbp-default-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/bbpress/templates/default/css/bbpress6640.css?ver=2.5.12-6148'
	type='text/css' media='screen' />
<link property="stylesheet" rel='stylesheet' id='bp-legacy-css-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/buddypress/bp-templates/bp-legacy/css/buddypress.minae29.css?ver=2.7.4'
	type='text/css' media='screen' />
<link property="stylesheet" rel='stylesheet' id='contact-form-7-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/contact-form-7/includes/css/styles167b.css?ver=4.6'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet' id='wise_chat_core-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/wise-chat/css/wise_chat447e.css?ver=4.7.7'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='wpProQuiz_front_style-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/wp-pro-quiz/css/wpProQuiz_front.min3496.css?ver=0.37'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='weblator_polling-plugin-styles-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/responsive-poll/public/assets/css/public905d.css?ver=1.6.3'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='weblator_polling-fa-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/responsive-poll/public/assets/css/font-awesome.min905d.css?ver=1.6.3'
	type='text/css' media='all' />
<!--[if gt IE 8]>
<link property="stylesheet" rel='stylesheet' id='micro_office-main-style-css-ie-css'  href='http://microoffice.themerex.net/wp-content/themes/micro-office/css/ie.css' type='text/css' media='all' />
<![endif]-->
<link property="stylesheet" rel='stylesheet'
	id='micro_office-font-Open-Sans-style-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/css/font-face/Open_Sans/stylesheet.css'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='micro_office-font-google_fonts-style-css'
	href='../fonts.googleapis.com/cssd4c0.css?family=Lato%3A300%2C300italic%2C400%2C400italic%2C700%2C700italic%26subset%3Dlatin%2Clatin-ext'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='micro_office-fontello-style-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/css/fontello/css/fontello.css'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='micro_office-main-style-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/style.css'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='micro_office-animation-style-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/fw/css/core.animation.css'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='micro_office-shortcodes-style-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/shortcodes/theme.shortcodes.css'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='micro_office-theme-style-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/css/theme.css'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='micro_office-theme-style-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/css-lib/jquery.dataTables.min.css'
	type='text/css' media='all' />
<style id='micro_office-theme-style-inline-css' type='text/css'>
.sidebar_outer_logo .logo_main, .top_panel_wrap .logo_main,
	.top_panel_wrap .logo_fixed {
	height: 45px
}
</style>
<link property="stylesheet" rel='stylesheet'
	id='micro_office-plugin.eventon-style-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/css/plugin.eventon.css'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='micro_office-plugin.wisechat-style-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/css/plugin.wisechat.css'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='micro_office-plugin.timeline-style-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/css/plugin.timeline.css'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='micro_office-plugin.buddypress-style-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/css/plugin.buddypress.css'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='micro_office-plugin.responsive-poll-style-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/css/plugin.responsive-poll.css'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='micro_office-responsive-style-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/css/responsive.css'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet' id='mediaelement-css'
	href='${pageContext.request.contextPath }/assets/css/wp-includes/js/mediaelement/mediaelementplayer.min51cd.css?ver=2.22.0'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet' id='wp-mediaelement-css'
	href='${pageContext.request.contextPath }/assets/css/wp-includes/js/mediaelement/wp-mediaelement.min447e.css?ver=4.7.7'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet' id='evcal_google_fonts-css'
	href='../fonts.googleapis.com/css4764.css?family=Oswald%3A400%2C300%7COpen+Sans%3A400%2C400i%2C300&amp;ver=4.7.7'
	type='text/css' media='screen' />
<link property="stylesheet" rel='stylesheet' id='evcal_cal_default-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/eventON/assets/css/eventon_styles367a.css?ver=2.4.10'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet' id='evo_font_icons-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/eventON/assets/fonts/font-awesome367a.css?ver=2.4.10'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet'
	id='eventon_dynamic_styles-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/eventON/assets/css/eventon_dynamic_styles447e.css?ver=4.7.7'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet' id='evo_fc_styles-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/eventon-full-cal/assets/fc_styles447e.css?ver=4.7.7'
	type='text/css' media='all' />
<link property="stylesheet" rel='stylesheet' id='js_composer_front-css'
	href='${pageContext.request.contextPath }/assets/css/wp-content/plugins/js_composer/assets/css/js_composer.min972f.css?ver=5.0.1'
	type='text/css' media='all' />
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/css/wp-includes/js/jquery/jqueryb8ff.js?ver=1.12.4'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/js/jquery-3.2.1.min.js?v=1.0'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/js/dataTables.bootstrap.min.js?v=1.0'></script>	
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/js/jquery.dataTables.min.js?v=1.0'></script>	
	<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/js/template.js?v=1.0'></script>
	<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/css/wp-content/js-lib/jquery.dataTables.min.js'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/css/wp-includes/js/jquery/jquery-migrate.min330a.js?ver=1.4.1'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/content_timeline/js/frontend/jquery.easing.1.3447e.js?ver=4.7.7'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/content_timeline/js/frontend/jquery.timeline447e.js?ver=4.7.7'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/content_timeline/js/frontend/jquery.mousewheel.min447e.js?ver=4.7.7'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/content_timeline/js/frontend/jquery.mCustomScrollbar.min447e.js?ver=4.7.7'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/content_timeline/js/frontend/rollover447e.js?ver=4.7.7'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/content_timeline/js/frontend/jquery.prettyPhoto447e.js?ver=4.7.7'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/content_timeline/js/frontend/jquery.my_add_function447e.js?ver=4.7.7'></script>
<script type='text/javascript'>
/* <![CDATA[ */
var BP_Confirm = {"are_you_sure":"Are you sure?"};
/* ]]> */

/* <![CDATA[ */
var BP_DTheme = {"accepted":"Accepted","close":"Close","comments":"comments","leave_group_confirm":"Are you sure you want to leave this group?","mark_as_fav":"Favorite","my_favs":"My Favorites","rejected":"Rejected","remove_fav":"Remove Favorite","show_all":"Show all","show_all_comments":"Show all comments for this thread","show_x_comments":"Show all %d comments","unsaved_changes":"Your profile has unsaved changes. If you leave the page, the changes will be lost.","view":"View"};
/* ]]> */
</script>
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/buddypress/bp-templates/bp-legacy/js/buddypress.minae29.js?ver=2.7.4'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/responsive-poll/public/assets/js/vendors/excanvas905d.js?ver=1.6.3'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/fw/js/photostack/modernizr.min.js'></script>
<link rel="wlwmanifest" type="application/wlwmanifest+xml"
	href="${pageContext.request.contextPath }/assets/css/wp-includes/wlwmanifest.xml" />
<meta name="generator" content="WordPress 4.7.7" />
<link rel="canonical" href="index.html" />
<link rel='shortlink' href='../index8f5d.html?p=1989' />

<link href="../fonts.googleapis.com/css55d0.css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/wp-content/plugins/responsive-poll/public/assets/css/notie.css">

<!-- EventON Version -->
<meta name="generator" content="EventON 2.4.10" />

<meta name="generator"
	content="Powered by Visual Composer - drag and drop page builder for WordPress." />
<!--[if lte IE 9]><link rel="stylesheet" type="text/css" href="http://microoffice.themerex.net/wp-content/plugins/js_composer/assets/css/vc_lte_ie9.min.css" media="screen"><![endif]-->
<link rel="icon"
	href="${pageContext.request.contextPath }/assets/css/wp-content/uploads/2016/10/cropped-512x512-32x32.png"
	sizes="32x32" />
<link rel="icon"
	href="${pageContext.request.contextPath }/assets/css/wp-content/uploads/2016/10/cropped-512x512-192x192.png"
	sizes="192x192" />
<link rel="apple-touch-icon-precomposed"
	href="${pageContext.request.contextPath }/assets/css/wp-content/uploads/2016/10/cropped-512x512-180x180.png" />
<meta name="msapplication-TileImage"
	content="http://microoffice.themerex.net/wp-content/uploads/2016/10/cropped-512x512-270x270.png" />
<noscript>
	<style type="text/css">
.wpb_animate_when_almost_visible {
	opacity: 1;
}
</style>
</noscript>
</head>

<body
	class="page-template-default page page-id-1989 micro_office_body body_style_wide body_type_1 body_transparent article_style_stretch layout_single-standard template_single-standard scheme_original top_panel_hide sidebar_show sidebar_show sidebar_outer_show sidebar_outer_show wpb-js-composer js-comp-ver-5.0.1 vc_responsive no-js">



	<div class="body_wrap">
		<div class="page_wrap">



			<header class="top_panel_wrap">
				<div class="top_panel_wrap_inner">
					<div class="menu_pushy">
						<span class="icon-menu">Menu</span>
					</div>
					<div class="content_wrap">
						<div class="contact_logo">
							<div class="logo">
								<a href="../index.html"><img
									src="${pageContext.request.contextPath }/assets/css/wp-content/uploads/2016/08/logo.png"
									class="logo_main" alt="" width="202" height="44"><img
									src="${pageContext.request.contextPath }/assets/css/wp-content/uploads/2016/08/logo.png"
									class="logo_fixed" alt="" width="202" height="44"></a>
							</div>
						</div>
					</div>
					<div class="sidebar_wrap sidebar">
						<div class="top_panel_controls">
							<div class="sidebar_pushy">
								<a href="${pageContext.request.contextPath }/general/login.html"><h2>Login</h2></a>
							</div>
							<div class="sidebar_pushy">
								<a href="#" class="pushy_button sc_button"><span
									class="icon-right-open"></span></a>
							</div>
							
						</div>
					</div>
				</div>
			</header>
			<!-- </.top_panel_wrap> -->
			<div class="page_content_wrap">
				<div class="menu_main_wrap">
				<input type="hidden" id="label-flag" value="${label }"/>
					<nav class="menu_main_nav_area">
						<ul id="menu_main" class="menu_main_nav">
							<li id="home-label"
								class="icon-folder menu-item menu-item-type-custom menu-item-object-custom current-menu-ancestor current-menu-parent menu-item-has-children menu-item-4"><a
								href="${pageContext.request.contextPath }/test/index.html"><span>Home</span></a>
							</li>
							<li id="about-us-label"
								class="icon-users-group menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-2165"><a
								href="aboutus.html"><span>About Us</span></a></li>
							<li id="category-label"
								class="icon-book menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-2169"><a href="${pageContext.request.contextPath }/category/index.html"><span>Category</span></a>
								
								<ul class="sub-menu">
								
									<c:forEach var="category" items="${categories }">
									<li id="menu-item-2346"
										class="menu-item menu-item-type-post_type menu-item-object-page menu-item-2346"><a
										href="${pageContext.request.contextPath }/category/examsbycategory.html?id=${category.id }">${category.name }</a></li>
									</c:forEach>
								</ul>
								
							</li>
							<li id="education-label"
								class="icon-school menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-2169"><a><span>Exam</span></a>
								</li>
							<li id="result-label"
								class="icon-rocket menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-2165"><a><span>Question</span></a></li>											
						</ul>
					</nav>
				</div>

				<div class="content_wrap with_title">
					<div class="top_panel_title">
						<div class="top_panel_title_inner"></div>
					</div>
					<article
						class="itemscope post_item post_item_single post_featured_default post_format_standard post-2162 page type-page status-publish hentry"
						itemscope itemtype="http://schema.org/Article">
						<section class="post_content" itemprop="articleBody">
							<div class="vc_row wpb_row vc_row-fluid">
								<div class="wpb_column vc_column_container vc_col-sm-12">
									<div class="vc_column-inner ">
										<div class="wpb_wrapper">
											

														<tiles:insertAttribute name="content"></tiles:insertAttribute>

										</div>
									</div>
								</div>
							</div>
						</section>
						<!-- </section> class="post_content" itemprop="articleBody"> -->
						<section class="related_wrap related_wrap_empty"></section>

					</article>
				</div>


				<!-- </div> class="content_wrap with_title"> -->
				<div class="sidebar_wrap sidebar widget_area scheme_original"
					role="complementary">
					<div class="sidebar_inner widget_area_inner">
						<aside id="micro_office_widget_birthdays-2"
							class="widget_number_1 widget widget_birthdays">
							<h5 class="widget_title">Account</h5>
${accoutInfo.firstname }

<br/><br/>
<div><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></div>
						</aside>
					</div>
				</div>
				<!-- /.sidebar -->

			</div>
			<!-- </.page_content_wrap> -->

			<footer class="footer_wrap widget_area scheme_original">
				<div class="footer_wrap_inner widget_area_inner">
					<div class="content_wrap">

						</aside>
						<aside id="text-7"
							class="widget_number_2 column-1_3 widget widget_text">
							<h5 class="widget_title">Contact us</h5>
							<div class="textwidget">
								<ul class="sc_list sc_list_style_iconed">
									<li class="sc_list_item odd first"><span
										class="sc_list_icon icon-location-1" style="color: #191315;"></span>
										<div class="wpb_text_column wpb_content_element ">
											<div class="wpb_wrapper">
												<h6>Address:</h6>
												<div>White House - Team 2 million</div>

											</div>
										</div></li>
									<li class="sc_list_item even"><span
										class="sc_list_icon icon-phone-circled"
										style="color: #191315;"></span>
										<div class="wpb_text_column wpb_content_element ">
											<div class="wpb_wrapper">
												<h6>Call Us:</h6>
												<p>1080</p>

											</div>
										</div></li>
									<li class="sc_list_item odd"><span
										class="sc_list_icon icon-pencil-neg" style="color: #191315;"></span>
										<div class="wpb_text_column wpb_content_element ">
											<div class="wpb_wrapper">
												<h6>Email:</h6>
												<p>team2million@abc.com</p>


											</div>
											<!-- /.footer_wrap_inner -->
			</footer>
			<!-- /.footer_wrap -->

			<div class="copyright_wrap copyright_style_text  scheme_original">
				<div class="copyright_wrap_inner">
					<div class="content_wrap">
						<div class="copyright_text">
							Micro Office � 2016-2017 All Rights Reserved. <a href="#">Terms
								of use</a> and <a href="#">Privacy Policy</a>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- /.page_wrap -->

	</div>
	<!-- /.body_wrap -->

	<script type="text/javascript">
		/*<![CDATA[*/
		var gmapstyles = 'default';
		/* ]]> */
		</script>
	<div class='evo_lightboxes'>
		<div class='evo_lightbox eventcard eventon_events_list' id=''>
			<div class="evo_content_in">
				<div class="evo_content_inin">
					<div class="evo_lightbox_content">
						<a class='evolbclose '>X</a>
						<div
							class='evo_lightbox_body eventon_list_event evo_pop_body evcal_eventcard'></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<link property="stylesheet" rel='stylesheet'
		id='micro_office-messages-style-css'
		href='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/fw/js/core.messages/core.messages.css'
		type='text/css' media='all' />
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-includes/js/jquery/ui/core.mine899.js?ver=1.11.4'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-includes/js/jquery/ui/widget.mine899.js?ver=1.11.4'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-includes/js/jquery/ui/mouse.mine899.js?ver=1.11.4'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-includes/js/jquery/ui/draggable.mine899.js?ver=1.11.4'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/bbpress/templates/default/js/editor6640.js?ver=2.5.12-6148'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-includes/js/comment-reply.min447e.js?ver=4.7.7'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/contact-form-7/includes/js/jquery.form.mind03d.js?ver=3.51.0-2014.06.20'></script>
	<script type='text/javascript'>
/* <![CDATA[ */
var _wpcf7 = {"recaptcha":{"messages":{"empty":"Please verify that you are not a robot."}}};
/* ]]> */
</script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/contact-form-7/includes/js/scripts167b.js?ver=4.6'></script>
	<script type='text/javascript'>
/* <![CDATA[ */
/* ]]> */
</script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/trx_utils/js/trx_utils.js'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/responsive-poll/public/assets/js/vendors/chartjs_new905d.js?ver=1.6.3'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/responsive-poll/public/assets/js/app/legend905d.js?ver=1.6.3'></script>
	<script type='text/javascript'>
/* <![CDATA[ */
/* ]]> */
</script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/responsive-poll/public/assets/js/app/poll905d.js?ver=1.6.3'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/responsive-poll/public/assets/js/app/poll-init905d.js?ver=1.6.3'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/fw/js/superfish.js'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/fw/js/core.utils.js'></script>
	<script type='text/javascript'>
/* <![CDATA[ */
var MICRO_OFFICE_STORAGE = {"system_message":{"message":"","status":"","header":""},"theme_font":"Open Sans","theme_color":"#2A3342","theme_bg_color":"#E9E9E9","strings":{"ajax_error":"Invalid server answer","bookmark_add":"Add the bookmark","bookmark_added":"Current page has been successfully added to the bookmarks. You can see it in the right panel on the tab &#039;Bookmarks&#039;","bookmark_del":"Delete this bookmark","bookmark_title":"Enter bookmark title","bookmark_exists":"Current page already exists in the bookmarks list","search_error":"Error occurs in AJAX search! Please, type your query and press search icon for the traditional search way.","email_confirm":"On the e-mail address &quot;%s&quot; we sent a confirmation email. Please, open it and click on the link.","reviews_vote":"Thanks for your vote! New average rating is:","reviews_error":"Error saving your vote! Please, try again later.","error_like":"Error saving your like! Please, try again later.","error_global":"Global error text","name_empty":"The name can&#039;t be empty","name_long":"Too long name","email_empty":"Too short (or empty) email address","email_long":"Too long email address","email_not_valid":"Invalid email address","subject_empty":"The subject can&#039;t be empty","subject_long":"Too long subject","text_empty":"The message text can&#039;t be empty","text_long":"Too long message text","send_complete":"Send message complete!","send_error":"Transmit failed!","not_agree":"Please, check &#039;I agree with Terms and Conditions&#039;","login_empty":"The Login field can&#039;t be empty","login_long":"Too long login field","login_success":"Login success! The page will be reloaded in 3 sec.","login_failed":"Login failed!","password_empty":"The password can&#039;t be empty and shorter then 4 characters","password_long":"Too long password","password_not_equal":"The passwords in both fields are not equal","registration_success":"Registration success! Please log in!","registration_failed":"Registration failed!","geocode_error":"Geocode was not successful for the following reason:","googlemap_not_avail":"Google map API not available!","editor_save_success":"Post content saved!","editor_save_error":"Error saving post data!","editor_delete_post":"You really want to delete the current post?","editor_delete_post_header":"Delete post","editor_delete_success":"Post deleted!","editor_delete_error":"Error deleting post!","editor_caption_cancel":"Cancel","editor_caption_close":"Close"},"ajax_url":"http:\/\/microoffice.themerex.net\/wp-admin\/admin-ajax.php","ajax_nonce":"69cc004c92","site_url":"http:\/\/microoffice.themerex.net","site_protocol":"http","vc_edit_mode":"","accent1_color":"#2A3342","accent1_hover":"#1EBEB4","slider_height":"100","user_logged_in":"","toc_menu":null,"toc_menu_home":"","toc_menu_top":"","menu_fixed":"","menu_mobile":"0","menu_hover":"","menu_cache":"","button_hover":"","input_hover":"default","demo_time":"0","media_elements_enabled":"1","ajax_search_enabled":"1","ajax_search_min_length":"3","ajax_search_delay":"200","css_animation":"1","menu_animation_in":"","menu_animation_out":"","popup_engine":"magnific","email_mask":"^([a-zA-Z0-9_\\-]+\\.)*[a-zA-Z0-9_\\-]+@[a-z0-9_\\-]+(\\.[a-z0-9_\\-]+)*\\.[a-z]{2,6}$","contacts_maxlength":"1000","comments_maxlength":"1000","remember_visitors_settings":"","admin_mode":"","isotope_resize_delta":"0.3","error_message_box":null,"viewmore_busy":"","video_resize_inited":"","top_panel_height":"0"};
/* ]]> */
</script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/fw/js/core.init.js'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/js/theme.init.js'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/fw/js/jquery.cookie.js'></script>
	<script type='text/javascript'>
/* <![CDATA[ */
var mejsL10n = {"language":"en-US","strings":{"Close":"Close","Fullscreen":"Fullscreen","Turn off Fullscreen":"Turn off Fullscreen","Go Fullscreen":"Go Fullscreen","Download File":"Download File","Download Video":"Download Video","Play":"Play","Pause":"Pause","Captions\/Subtitles":"Captions\/Subtitles","None":"None","Time Slider":"Time Slider","Skip back %1 seconds":"Skip back %1 seconds","Video Player":"Video Player","Audio Player":"Audio Player","Volume Slider":"Volume Slider","Mute Toggle":"Mute Toggle","Unmute":"Unmute","Mute":"Mute","Use Up\/Down Arrow keys to increase or decrease volume.":"Use Up\/Down Arrow keys to increase or decrease volume.","Use Left\/Right Arrow keys to advance one second, Up\/Down arrows to advance ten seconds.":"Use Left\/Right Arrow keys to advance one second, Up\/Down arrows to advance ten seconds."}};
var _wpmejsSettings = {"pluginPath":"\/${pageContext.request.contextPath }/assets/css/wp-includes\/js\/mediaelement\/"};
/* ]]> */
</script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-includes/js/mediaelement/mediaelement-and-player.min51cd.js?ver=2.22.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-includes/js/mediaelement/wp-mediaelement.min447e.js?ver=4.7.7'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/fw/js/core.debug.js'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-includes/js/wp-embed.min447e.js?ver=4.7.7'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/fw/js/core.messages/core.messages.js'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/themes/micro-office/shortcodes/theme.shortcodes.js'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/js_composer/assets/js/dist/js_composer_front.min972f.js?ver=5.0.1'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/eventON/assets/js/eventon_functions367a.js?ver=2.4.10'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/eventON/assets/js/jquery.mobile.min367a.js?ver=2.4.10'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/eventON/assets/js/jquery.mousewheel.min367a.js?ver=2.4.10'></script>
	<script type='text/javascript'>
/* <![CDATA[ */
var the_ajax_script = {"ajaxurl":"http:\/\/microoffice.themerex.net\/wp-admin\/admin-ajax.php","postnonce":"b3b4351cae"};
/* ]]> */
</script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/eventON/assets/js/eventon_script367a.js?ver=2.4.10'></script>
	<script type='text/javascript'
		src='../maps.googleapis.com/maps/api/js5152?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/eventON/assets/js/maps/eventon_gen_maps367a.js?ver=2.4.10'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/eventON/assets/js/maps/eventon_init_gmap5152.js?ver=1.0'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/wise-chat/js/utils/messages_history447e.js?ver=4.7.7'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/wise-chat/js/ui/messages447e.js?ver=4.7.7'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/wise-chat/js/ui/settings447e.js?ver=4.7.7'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/wise-chat/js/maintenance/executor447e.js?ver=4.7.7'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/wise-chat/js/wise_chat447e.js?ver=4.7.7'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/eventon-full-cal/assets/jquery.easing.1.3c64e.js?ver=1.1.1'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/eventon-full-cal/assets/jquery.mobile.minc64e.js?ver=1.1.1'></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/assets/css/wp-content/plugins/eventon-full-cal/assets/fc_scriptc64e.js?ver=1.1.1'></script>

</body>

<!-- Mirrored from microoffice.themerex.net/home-2/ by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 27 Nov 2017 15:25:22 GMT -->
</html>