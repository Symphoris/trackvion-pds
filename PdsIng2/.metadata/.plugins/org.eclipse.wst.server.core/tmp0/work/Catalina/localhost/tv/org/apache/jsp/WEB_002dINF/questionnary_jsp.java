/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.24
 * Generated at: 2020-02-24 11:20:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class questionnary_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Les JSPs ne permettent que GET, POST ou HEAD. Jasper permet aussi OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!DOCTYPE html>\r\n");
      out.write("\t\t\t\t<html>\r\n");
      out.write("\t\t\t\t<head>\r\n");
      out.write("\t\t\t\t<link href=\"/tv/common/styleMain.css\" rel=\"stylesheet\">\r\n");
      out.write("\t\t\t\t<link rel=\"stylesheet\"\r\n");
      out.write("\t\t\t\t\thref=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("\t\t\t\t<link rel=\"icon\" type=\"image/png\" href=\"/tv/pictures/icon.png\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<link rel=\"stylesheet\"\r\n");
      out.write("\t\t\t\t\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n");
      out.write("\t\t\t\t\tintegrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\r\n");
      out.write("\t\t\t\t\tcrossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<script type=\"text/javascript\" src=\"/tv/script/includeHTML.js\"></script>\r\n");
      out.write("\t\t\t\t<script type=\"text/javascript\" src=\"/tv/script/toggleMenu.js\"></script>\r\n");
      out.write("\t\t\t\t<script type=\"text/javascript\" src=\"/tv/script/questionnary.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<script\r\n");
      out.write("\t\t\t\t\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"\r\n");
      out.write("\t\t\t\t\tintegrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\"\r\n");
      out.write("\t\t\t\t\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<title>TrackVision</title>\r\n");
      out.write("\t\t\t\t</head>\r\n");
      out.write("\t\t\t\t<body>\r\n");
      out.write("\t\t\t\t\t<div w3-include-html=\"/tv/common/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${menu}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(".html\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- question about the state of health -->\r\n");
      out.write("\t\t\t\t\t<div style=\"padding-left: 16px\">\r\n");
      out.write("\t\t\t\t\t\t<br> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${optionalMessage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<h3>please complete this questionnary</h3>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t\t\t\t<form action=\"/tv/questionnary\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"col-md-6\">Are you sick?</label> <label\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"col-md-6\" id=\"question\" style=\"display: none;\" required>what\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tare your pathologie?</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\" id=\"diseaseRadioDisplay\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-xs-6 col-md-6 col-lg-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"diseaseyes\" name=\"isdisease\" value=\"yes\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tonclick=\"displayDisease()\" required> <label for=\"yes\">yes</label>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"athleteNo\" name=\"isdisease\" value=\"No\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tonclick=\"displayDisease()\" checked> <label for=\"No\">No</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-xs-6 col-md-6 col-lg-6\" id=\"whatdisease\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"hypertension\" name=\"diseasename\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvalue=\"hypertension\" checked> <label for=\"huey\">hyper\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttension</label> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"diabetes\" name=\"diseasename\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvalue=diabetes> <label for=\"dewey\">diabetes</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"col-md-6\">Are you sporty?</label> <label\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"col-md-6\" id=\"sport\" style=\"display: none;\">what\r\n");
      out.write("\t\t\t\t\t\t\t\t\tfrequency?</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\" id=\"athleteRadioDisplay\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-xs-6 col-md-6 col-lg-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"athleteoui\" name=\"athlete\" value=\"yes\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tonclick=\"displayAthlete()\"> <label for=\"oui\">Yes</label>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"athletenon\" name=\"athlete\" value=\"No\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tonclick=\"displayAthlete()\" checked> <label for=\"non\">No</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-xs-6 col-md-6 col-lg-6\" id=\"athletefreq\" style=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"once a week\" name=\"frequence\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvalue=\"once a week\" checked> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"huey\">once a week</label> <input type=\"radio\" id=\"twice a week\" name=\"frequence\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvalue=\"twice a week\"> <label for=\"dewey\">twice a\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tweek</label> <input type=\"radio\" id=\"three or more times a week\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"frequence\" value=\"three or more times a week\"> <label\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfor=\"louie\">three or more times a week</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"col-xs-6 col-md-6 col-lg-6\">Are you allergic?</label> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"col-xs-6 col-md-6 col-lg-6\" id=\"questionallergie\" style=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\twhat are your allergies? </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\" id=\"allergieRadioDisplay\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-xs-6 col-md-6 col-lg-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"allergieoui\" name=\"allergie\" value=\"yes\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tonclick=\"displayAllergie()\"> <label for=\"oui\">Yes</label>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"allergienon\" name=\"allergie\" value=\"no\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tonclick=\"displayAllergie()\" checked> <label for=\"non\">No</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-xs-6 col-md-6 col-lg-6\" id=\"allergietype\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<textarea id=\"story\" name=\"allergiename\" rows=\"2\" cols=\"5\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"col-xs-6 col-md-6 col-lg-6\"> Are you disabled?</label> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"col-xs-6 col-md-6 col-lg-6\" id=\"questiondisabled\" style=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\twhat are your disabilities? </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\" id=\"disabledRadioDisplay\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-xs-6 col-md-6 col-lg-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"disabledoui\" name=\"disabled\" value=\"yes\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tonclick=\"displayDisabled()\"> <label for=\"oui\">Yes</label>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"allergienon\" name=\"disabled\" value=\"no\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tonclick=\"displayDisabled()\" checked> <label for=\"non\">No</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-xs-6 col-md-6 col-lg-6\" id=\"disabledtype\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"wheelchair\" name=\"whichdisabled\" value=\"wheelchair\">\r\n");
      out.write("\t\t\t\t  \t\t\t\t\t\t<label for=\"vehicle1\">  I'm in a wheelchair </label>\r\n");
      out.write("\t\t\t\t  \t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"crutch\" name=\"whichdisabled\" value=\"crutch\">\r\n");
      out.write("\t\t\t\t  \t\t\t\t\t\t<label for=\"vehicle1\">  I walk on crutches </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"blind\" name=\"whichdisabled\" value=\"blind\">\r\n");
      out.write("\t\t\t\t  \t\t\t\t\t\t<label for=\"vehicle1\"> I am blind</label>\r\n");
      out.write("\t\t\t\t  \t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t  \t\t\t\t\t\t<input type=\"checkbox\" id=\"deaf\" name=\"whichdisabled\" value=\"deaf\">\r\n");
      out.write("\t\t\t\t  \t\t\t\t\t\t<label for=\"vehicle1\"> I am deaf</label>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"col-md-6\">how are you going to finance your stay ? </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t \t<label class=\"col-md-6\" id=\"summax\" style=\"display: none;\"> what is the maximum amount you can pay?\r\n");
      out.write("\t\t\t\t\t\t\t\t \t</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t \t<label class=\"col-md-6\" id=\"questionallergie\" style=\"display: none;\"> what are your allergies \r\n");
      out.write("\t\t\t\t\t\t\t\t \t</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\" id=\"financeRadioDisplay\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-xs-6 col-md-6 col-lg-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"alone\" name=\"finance\" value=\"alone\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tonclick=\"displayFinance()\"> <label for=\"alone\">Alone</label>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"pension\" name=\"finance\" value=\"pension\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tonclick=\"displayFinance()\"> <label for=\"with a pension fund\">With a pension fund</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"social\" name=\"finance\" value=\"social\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tonclick=\"displayFinance()\"> <label for=\"social\">social assistance for accommodation</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-xs-6 col-md-6 col-lg-6\" id=\"whatpension\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <select name=\"agency\" id=\"pet-select\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <option value=\"\">--Please choose an option--</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <option value=\"CNAV\"> CNAV(Régime général de la sécurité sociale) </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <option value=\"MSA\"> MSA (Mutualité Sociale Agricole) </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <option value=\"IRCANTEC\"> IRCANTEC (Institution de Retraite Complémentaire des Agents Non\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t     Titulaires de l'Etat et des Collectivités publiques)</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <option value=\"CRPN\"> CRPN (Caisse de retraite du personnel navigant professionnel de l'aéronautique civile)</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <option value=\"CNAVPL\">  CNAVPL(Caisse Nationale d'Assurance Vieillesse des Professions Libérales) </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <option value=\"RSI\"> RSI(Régime Social des Indépendants) </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <option value=\"MSA\">  MSA(Mutualité Sociale Agricole)  </option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <option value=\"FSPOEIE\">   FSPOEIE(Fonds Spécial des Ouvriers des Etablissements de l'Etat)</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-xs-6 col-md-6 col-lg-6\" id=\"summemax\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"number\"  id=\"summax\" name=\"summax\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tplaceholder=\"Your  maximum amount ..\" size=\"50\" style=\"width:100px\";\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"submit\" value=\"Submit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<div w3-include-html=\"/tv/common/footer.html\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<script>\r\n");
      out.write("\t\t\t\t\t\tincludeHTML();\r\n");
      out.write("\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t</body>\r\n");
      out.write("\t\t\t\t</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}