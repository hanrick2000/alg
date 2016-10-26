\documentclass[paper=a4,fontsize=11pt]{scrartcl} % KOMA-article class
              
\usepackage[english]{babel}
\usepackage[utf8x]{inputenc}
\usepackage[protrusion=true,expansion=true]{microtype}
\usepackage{amsmath,amsfonts,amsthm}     % Math packages
\usepackage{graphicx}                    % Enable pdflatex
\usepackage[svgnames]{xcolor}            % Colors by their 'svgnames'
\usepackage{geometry}
  \textheight=700px                    % Saving trees ;-)
\usepackage{url}

\frenchspacing              % Better looking spacings after periods
\pagestyle{empty}           % No pagenumbers/headers/footers


%%% ------------------------------------------------------------
\usepackage{sectsty}

\sectionfont{%                  % Change font of \section command
  \usefont{OT1}{phv}{b}{n}%    % bch-b-n: CharterBT-Bold font
  \sectionrule{0pt}{0pt}{-5pt}{3pt}}

%%% Macros
\newlength{\spacebox}
\settowidth{\spacebox}{8888888888}      % Box to align text
\newcommand{\sepspace}{\vspace*{1em}}    % Vertical space macro

\newcommand{\MyName}[1]{ % Name
    \Huge \usefont{OT1}{phv}{b}{n} \hfill #1
    \par \normalsize \normalfont}
    
\newcommand{\MySlogan}[1]{ % Slogan (optional)
    \large \usefont{OT1}{phv}{m}{n}\hfill \textit{#1}
    \par \normalsize \normalfont}

\newcommand{\NewPart}[1]{\section*{\uppercase{#1}}}

\newcommand{\PersonalEntry}[2]{
    \noindent\hangindent=2em\hangafter=0 % Indentation
    \parbox{\spacebox}{        % Box to align text
    \textit{#1}}           % Entry name (birth, address, etc.)
    \hspace{1.5em} #2 \par}    % Entry value

\newcommand{\SkillsEntry}[2]{      % Same as \PersonalEntry
    \noindent\hangindent=2em\hangafter=0 % Indentation
    \parbox{\spacebox}{        % Box to align text
    \textit{#1}}         % Entry name (birth, address, etc.)
    \hspace{1.5em} #2 \par}    % Entry value  
    
\newcommand{\EducationEntryMaster}[3]{
    \noindent \textbf{#1} \hfill      % Study
    \colorbox{Black}{%
      \parbox{6em}{%
      \hfill\color{White}#2}} \par  % Duration
    \noindent \textit{#3} \par        % School
    \normalsize \par}
        
\newcommand{\EducationEntryBachler}[4]{
    \noindent \textbf{#1} \hfill      % Study
    \colorbox{Black}{%
      \parbox{6em}{%
      \hfill\color{White}#2}} \par  % Duration
    \noindent \textit{#3} \par        % School
        \noindent \textit{#4} \par        % School
    \normalsize \par}

\newcommand{\WorkEntry}[5]{          
    \noindent \textbf{#1} \hfill                       % Jobname
    \colorbox{Black}{\color{White}#2} \par             % Duration
    \noindent \textit{#3} \par                         % Company
    \noindent\hangindent=2em\hangafter=0 \small #4     % Project
    \noindent\hangindent=4em\hangafter=0 \small #5 % Description
    \normalsize \par}

%%% Begin Document
\begin{document}
\MyName{Wang Yang}
\MySlogan{Target: Software Engineer}
\sepspace

%%% Personal details
\NewPart{Personal details}{}
\PersonalEntry{Phone}{(+86) 13552133119}
\PersonalEntry{Mail}{\url{khil.wang@gmail.com}}

%%% Education
\NewPart{Education}{}
\EducationEntryMaster{MSc. Computer Science}{2009-2012}{Chinese Academy of Science Software Institude}
\sepspace
\EducationEntryBachler{BSc. Telecommunication Engineering}{2005-2009}{Queen Mary, University of London} {Beijing University of Posts Telecommunications}

%%% Work experience
\NewPart{Work experience}{}
\WorkEntry{Senior Software Engineer}{2012-present}{Tencent, Full-time}{1. Online Advertising Training System.}{}
\sepspace

%%% Skills
\NewPart{Skills}{}
\SkillsEntry{Languages}{Java, Python, C++, Unix-like (*nix) Shell}
\SkillsEntry{Knowledge}{Data structure and Algorithm, Machine Learning, Distributed System}

\end{document}

