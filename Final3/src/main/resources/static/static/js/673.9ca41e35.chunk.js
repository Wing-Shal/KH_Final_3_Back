"use strict";(self.webpackChunkfinal3=self.webpackChunkfinal3||[]).push([[673],{7673:(e,s,c)=>{c.r(s),c.d(s,{default:()=>o});var t=c(5043),n=c(7580),a=c(9005),d=c(831),r=c(738),l=(c(8019),c(5475)),i=c(579);const o=function(){const[e,s]=(0,t.useState)(r),[c]=(0,d.L4)(a.g3),[o,h]=(0,t.useState)(),[x,j]=(0,t.useState)([]),[m,p]=(0,t.useState)(1),[y,b]=(0,t.useState)(6),u=(0,t.useCallback)((async()=>{try{const e=await n.A.get("/company/info");h(e.data)}catch(e){console.error("\ud68c\uc0ac \uc815\ubcf4 \ubd88\ub7ec\uc624\uae30 \uc624\ub958:",e)}}),[o]),N=(0,t.useCallback)((async()=>{try{const e=(await n.A.get("/emp/company/image")).data;s("".concat("http://localhost:8080","/download/").concat(e))}catch(e){s(r)}}),[]),g=(0,t.useCallback)((async()=>{try{const e=await n.A.get("/boardNotice/page/".concat(m,"/size/").concat(y));j(e.data.list)}catch(e){e.response&&404===e.response.status&&(console.log("\ub370\uc774\ud130 \uc5c6\uc74c."),j([]))}}),[m,y]);return(0,t.useEffect)((()=>{u(),N(),g()}),[]),(0,i.jsxs)(i.Fragment,{children:[(0,i.jsx)("h1",{children:"\ud68c\uc0ac \uc815\ubcf4"}),(0,i.jsx)("div",{className:"container-sm border border-5 rounded p-3 mb-3",children:(0,i.jsxs)("div",{className:"row align-items-center",children:[(0,i.jsx)("div",{className:"col-md-3",children:(0,i.jsx)("div",{children:c&&(0,i.jsx)("img",{src:e,alt:"\uc0ac\uc9c4 \ubbf8\ub9ac\ubcf4\uae30",style:{width:"230px",height:"300px",marginBottom:"10px",objectFit:"cover"},onError:e=>{e.target.src=r}})})}),o&&(0,i.jsx)("div",{className:"col-md-5",children:(0,i.jsx)("table",{className:"table",children:(0,i.jsxs)("tbody",{children:[(0,i.jsxs)("tr",{children:[(0,i.jsx)("td",{children:"\ud68c\uc0ac\uba85"}),(0,i.jsx)("td",{children:o.companyName})]}),(0,i.jsxs)("tr",{children:[(0,i.jsx)("td",{children:"\uc0ac\uc5c5\uc790\ub4f1\ub85d\ubc88\ud638"}),(0,i.jsx)("td",{children:o.companyBn})]}),(0,i.jsxs)("tr",{children:[(0,i.jsx)("td",{children:"\uc804\ud654\ubc88\ud638"}),(0,i.jsx)("td",{children:o.companyContact})]}),(0,i.jsxs)("tr",{children:[(0,i.jsx)("td",{children:"\uc774\uba54\uc77c"}),(0,i.jsx)("td",{children:o.companyEmail})]}),(0,i.jsxs)("tr",{children:[(0,i.jsx)("td",{children:"\uc6b0\ud3b8\ubc88\ud638"}),(0,i.jsx)("td",{children:o.companyZipcode})]}),(0,i.jsxs)("tr",{children:[(0,i.jsx)("td",{children:"\uc8fc\uc18c"}),(0,i.jsx)("td",{children:o.companyAddress1})]}),(0,i.jsxs)("tr",{children:[(0,i.jsx)("td",{children:"\uc0c1\uc138\uc8fc\uc18c"}),(0,i.jsx)("td",{children:o.companyAddress2})]})]})})}),(0,i.jsx)("div",{className:"col-md-4",children:(0,i.jsxs)("table",{className:"table",children:[(0,i.jsx)("thead",{className:"text-center",children:(0,i.jsxs)("tr",{className:"content-center",children:[(0,i.jsx)("th",{children:"\uc81c\ubaa9"}),(0,i.jsx)("th",{children:"\uc791\uc131\uc2dc\uac04"})]})}),(0,i.jsx)("tbody",{className:"text-center",children:x.map((e=>(0,i.jsxs)("tr",{children:[(0,i.jsx)("td",{children:(0,i.jsx)(l.N_,{className:"notice-link",to:"/board/notice/".concat(e.noticeNo),children:e.noticeTitle})}),(0,i.jsx)("td",{children:e.noticeWtime})]},e.noticeNo)))})]})})]})})]})}},8019:()=>{},738:(e,s,c)=>{e.exports=c.p+"static/media/CompanyLogo.3f803f494159655359b1.jpg"}}]);
//# sourceMappingURL=673.9ca41e35.chunk.js.map