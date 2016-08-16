package com.example.administrator.bobomanhua.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/9 0009.
 */
public class PagerBean {
    /**
     * status : 0
     * data : [{"title":"100话","sid":259,"id":2007323,"size":3.64,"counts":13,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1154188.shtml"},{"title":"99话","sid":258,"id":1994354,"size":3.91,"counts":23,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1153912.shtml"},{"title":"98话","sid":257,"id":1983198,"size":2.85,"counts":15,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1153552.shtml"},{"title":"92.5话","sid":250,"id":1846073,"size":2.55,"counts":15,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1150646.shtml"},{"title":"92话","sid":249,"id":1846072,"size":2.1,"counts":15,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1150645.shtml"},{"title":"91话","sid":248,"id":1846071,"size":3,"counts":15,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1150644.shtml"},{"title":"90话","sid":247,"id":1840630,"size":4.68,"counts":26,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1150551.shtml"},{"title":"89话","sid":246,"id":1822252,"size":5.18,"counts":14,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1150472.shtml"},{"title":"88话","sid":245,"id":1808925,"size":2.64,"counts":12,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1150391.shtml"},{"title":"87话","sid":244,"id":1799032,"size":1.52,"counts":8,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1150347.shtml"},{"title":"86话","sid":243,"id":1780826,"size":3.9,"counts":13,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1150254.shtml"},{"title":"85话","sid":242,"id":1767287,"size":2.8,"counts":10,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1150092.shtml"},{"title":"84话","sid":241,"id":1748655,"size":7.41,"counts":13,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1148940.shtml"},{"title":"83话","sid":240,"id":1738027,"size":3.5,"counts":14,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1148706.shtml"},{"title":"82话","sid":239,"id":1720439,"size":3.57,"counts":7,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1148178.shtml"},{"title":"81话","sid":238,"id":1717315,"size":1.54,"counts":14,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1148122.shtml"},{"title":"80话","sid":237,"id":1717314,"size":3.6,"counts":15,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1148120.shtml"},{"title":"79话","sid":236,"id":1717313,"size":1.8,"counts":15,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1148118.shtml"},{"title":"78话","sid":235,"id":1717312,"size":2.2,"counts":11,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1148116.shtml"},{"title":"77话","sid":234,"id":1717311,"size":1.52,"counts":8,"iszm":0,"surl":"http://www.hanhande.com/yiquanchaoren/1148114.shtml"},{"title":"一拳超人原作人气投票2","sid":233,"id":1697712,"size":3.08,"counts":77,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1147752.shtml"},{"title":"一拳超人原作人气投票←","sid":232,"id":1691390,"size":1.02,"counts":17,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1147612.shtml"},{"title":"一拳超人YJ番外特別篇","sid":231,"id":1691389,"size":5.6,"counts":35,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1147610.shtml"},{"title":"一拳超人原作版103（3）","sid":230,"id":1691388,"size":0.08,"counts":1,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1147608.shtml"},{"title":"一拳超人YJ番外篇","sid":229,"id":1680953,"size":2.66,"counts":14,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1147444.shtml"},{"title":"一拳超人原作版103（2）","sid":228,"id":1680952,"size":1.2,"counts":12,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1147440.shtml"},{"title":"一拳超人09卷附录","sid":227,"id":1671385,"size":1.5,"counts":10,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1147296.shtml"},{"title":"一拳超人原作版102（4）","sid":226,"id":1558755,"size":0.21,"counts":3,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1147088.shtml"},{"title":"一拳超人原作版102（3）","sid":225,"id":1558754,"size":0.56,"counts":8,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1147086.shtml"},{"title":"一拳超人原作版102（2）","sid":224,"id":1558753,"size":0.42,"counts":7,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1147084.shtml"},{"title":"一拳超人原作版102","sid":223,"id":1558752,"size":0.64,"counts":8,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1147082.shtml"},{"title":"一拳超人原作版101（3）","sid":222,"id":1483879,"size":0.56,"counts":8,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1146970.shtml"},{"title":"一拳超人原作版101（2）","sid":221,"id":1483878,"size":0.64,"counts":8,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1146968.shtml"},{"title":"一拳超人原作版101","sid":220,"id":1483877,"size":0.49,"counts":7,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1146966.shtml"},{"title":"76话","sid":219,"id":1339591,"size":0.92,"counts":4,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145802.shtml"},{"title":"75话","sid":218,"id":1339590,"size":2.43,"counts":9,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145800.shtml"},{"title":"74话","sid":217,"id":1339589,"size":3.36,"counts":16,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145798.shtml"},{"title":"73话","sid":216,"id":1339588,"size":4.95,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145796.shtml"},{"title":"72话","sid":215,"id":1339587,"size":2.56,"counts":8,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145794.shtml"},{"title":"71话","sid":214,"id":1339586,"size":2.52,"counts":12,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145792.shtml"},{"title":"70话","sid":213,"id":1339585,"size":1.8,"counts":12,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145790.shtml"},{"title":"69话","sid":212,"id":1339584,"size":2.97,"counts":9,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145788.shtml"},{"title":"一拳超人外传：24话","sid":211,"id":1332632,"size":0.24,"counts":2,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145380.shtml"},{"title":"68话","sid":210,"id":1332631,"size":2.28,"counts":19,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145370.shtml"},{"title":"一拳超人原作版100(1)-（3）","sid":209,"id":1332630,"size":2.53,"counts":23,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145362.shtml"},{"title":"一拳超人外传：23话","sid":208,"id":1332629,"size":0.27,"counts":3,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145356.shtml"},{"title":"一拳超人特别版","sid":207,"id":1332628,"size":2.99,"counts":23,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145352.shtml"},{"title":"一拳超人原作版100(1)","sid":206,"id":1332627,"size":0.5,"counts":5,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145348.shtml"},{"title":"一拳超人原作版99(3)","sid":205,"id":1332625,"size":0.48,"counts":8,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145344.shtml"},{"title":"一拳超人原作版99（2）","sid":204,"id":1332623,"size":0.24,"counts":3,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145340.shtml"},{"title":"一拳超人原作版68补","sid":203,"id":1332621,"size":1.5,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145332.shtml"},{"title":"一拳超人MJ番外篇","sid":201,"id":1332617,"size":4.5,"counts":25,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145316.shtml"},{"title":"一拳超人55-56话","sid":200,"id":1332615,"size":5.06,"counts":23,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145312.shtml"},{"title":"一拳超人50话","sid":199,"id":1332613,"size":2.38,"counts":14,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145302.shtml"},{"title":"一拳超人真49话","sid":198,"id":1332611,"size":2.73,"counts":13,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145298.shtml"},{"title":"一拳超人49话","sid":197,"id":1332609,"size":1.28,"counts":8,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145294.shtml"},{"title":"一拳超人48话","sid":196,"id":1332607,"size":4.18,"counts":19,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145290.shtml"},{"title":"一拳超人番外篇附录","sid":195,"id":1332605,"size":1.1,"counts":5,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145286.shtml"},{"title":"一拳超人超 47话","sid":194,"id":1332603,"size":5.04,"counts":36,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145282.shtml"},{"title":"一拳超人同人：穿越至彼端(腐向)","sid":193,"id":1332601,"size":4.5,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145276.shtml"},{"title":"一拳超人同人：最上位3战士谈论","sid":192,"id":1332599,"size":3.52,"counts":8,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145272.shtml"},{"title":"一拳超人村田老师版 可爱的野猫","sid":191,"id":1332597,"size":5.46,"counts":14,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145268.shtml"},{"title":"一拳超人真 47话","sid":190,"id":1332596,"size":8.16,"counts":24,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145264.shtml"},{"title":"一拳超人ONE老师版 可爱的野猫","sid":189,"id":1332593,"size":2.4,"counts":10,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145260.shtml"},{"title":"一拳超人47话","sid":188,"id":1332591,"size":2.86,"counts":11,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145256.shtml"},{"title":"一拳超人外传：16话","sid":187,"id":1332590,"size":5.25,"counts":75,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145252.shtml"},{"title":"一拳超人二次人气投票","sid":186,"id":1332588,"size":5.25,"counts":75,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145248.shtml"},{"title":"一拳超人一次人气投票","sid":185,"id":1332586,"size":1.5,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145242.shtml"},{"title":"一拳超人ONE老师漫画教学","sid":184,"id":1332584,"size":0.5,"counts":5,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145238.shtml"},{"title":"一拳超人真 45话","sid":183,"id":1332582,"size":5.4,"counts":20,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145234.shtml"},{"title":"一拳超人谜之更新回","sid":182,"id":1332581,"size":3.38,"counts":13,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145230.shtml"},{"title":"一拳超人外传：弹丸天使","sid":181,"id":1332578,"size":7.2,"counts":40,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145226.shtml"},{"title":"一拳超人番外篇8","sid":180,"id":1332576,"size":0.96,"counts":4,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145222.shtml"},{"title":"一拳超人真 46话","sid":179,"id":1332574,"size":4.8,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145218.shtml"},{"title":"一拳超人46话","sid":178,"id":1332573,"size":2.16,"counts":9,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145214.shtml"},{"title":"一拳超人超 45话","sid":177,"id":1332570,"size":11.52,"counts":24,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145210.shtml"},{"title":"一拳超人45话","sid":176,"id":1332568,"size":3.96,"counts":18,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145206.shtml"},{"title":"一拳超人44话","sid":175,"id":1332566,"size":4.75,"counts":19,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145202.shtml"},{"title":"一拳超人43话","sid":174,"id":1332565,"size":2.7,"counts":18,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145198.shtml"},{"title":"一拳超人42话","sid":173,"id":1332563,"size":10.88,"counts":32,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145194.shtml"},{"title":"一拳超人41.2话","sid":172,"id":1332561,"size":0.99,"counts":9,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145190.shtml"},{"title":"一拳超人41话","sid":171,"id":1332558,"size":5.29,"counts":23,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145186.shtml"},{"title":"一拳超人40话","sid":170,"id":1332557,"size":7.68,"counts":16,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145182.shtml"},{"title":"一拳超人92.5话","sid":169,"id":1332555,"size":2.55,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145178.shtml"},{"title":"一拳超人92话","sid":168,"id":1332552,"size":2.1,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145174.shtml"},{"title":"一拳超人91话","sid":167,"id":1332550,"size":3,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145170.shtml"},{"title":"一拳超人90话","sid":166,"id":1332548,"size":2.55,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145166.shtml"},{"title":"一拳超人89话","sid":165,"id":1332546,"size":3.75,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145162.shtml"},{"title":"一拳超人88话","sid":164,"id":1332544,"size":2.25,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145158.shtml"},{"title":"一拳超人87话","sid":163,"id":1332542,"size":4.05,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145154.shtml"},{"title":"一拳超人85话","sid":162,"id":1332540,"size":5.1,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145148.shtml"},{"title":"一拳超人84话","sid":161,"id":1332538,"size":5.1,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145144.shtml"},{"title":"一拳超人83话","sid":160,"id":1332536,"size":1.35,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145140.shtml"},{"title":"一拳超人82话","sid":159,"id":1332534,"size":2.1,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145136.shtml"},{"title":"一拳超人81话","sid":158,"id":1332532,"size":1.65,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145132.shtml"},{"title":"一拳超人80话","sid":157,"id":1332530,"size":3.6,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145128.shtml"},{"title":"一拳超人79话","sid":156,"id":1332528,"size":1.8,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145124.shtml"},{"title":"一拳超人78话","sid":155,"id":1332526,"size":1.65,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145120.shtml"},{"title":"一拳超人77话","sid":154,"id":1332524,"size":3.15,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145116.shtml"},{"title":"一拳超人76话","sid":153,"id":1332522,"size":2.25,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145112.shtml"},{"title":"一拳超人75话","sid":152,"id":1332520,"size":1.95,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145108.shtml"},{"title":"一拳超人74话","sid":151,"id":1332518,"size":2.1,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145104.shtml"},{"title":"一拳超人73话","sid":150,"id":1332517,"size":1.8,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145100.shtml"},{"title":"一拳超人72话","sid":149,"id":1332515,"size":1.5,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145096.shtml"},{"title":"一拳超人71话","sid":148,"id":1332513,"size":1.35,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145092.shtml"},{"title":"一拳超人70话","sid":147,"id":1332510,"size":1.95,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145088.shtml"},{"title":"一拳超人69话","sid":146,"id":1332508,"size":2.4,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145084.shtml"},{"title":"一拳超人68话","sid":145,"id":1332504,"size":1.4,"counts":14,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145080.shtml"},{"title":"一拳超人67话","sid":144,"id":1332502,"size":1.5,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145076.shtml"},{"title":"一拳超人66话","sid":143,"id":1332501,"size":1.68,"counts":14,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145072.shtml"},{"title":"一拳超人65话","sid":142,"id":1332499,"size":1.5,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145068.shtml"},{"title":"一拳超人64话","sid":141,"id":1332496,"size":1.65,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145064.shtml"},{"title":"一拳超人63话","sid":140,"id":1332494,"size":1.8,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145060.shtml"},{"title":"一拳超人62话","sid":139,"id":1332493,"size":2.4,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145056.shtml"},{"title":"一拳超人61话","sid":138,"id":1332490,"size":1.8,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145052.shtml"},{"title":"一拳超人60话","sid":137,"id":1332488,"size":2.25,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145048.shtml"},{"title":"一拳超人59话","sid":136,"id":1332486,"size":1.87,"counts":17,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145044.shtml"},{"title":"一拳超人58话","sid":135,"id":1332484,"size":3.22,"counts":14,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145040.shtml"},{"title":"一拳超人57话","sid":134,"id":1332482,"size":2.1,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145036.shtml"},{"title":"一拳超人56话","sid":133,"id":1332480,"size":1.6,"counts":16,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145032.shtml"},{"title":"一拳超人55话","sid":132,"id":1332477,"size":1.5,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145028.shtml"},{"title":"一拳超人54话","sid":131,"id":1332475,"size":1.5,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145024.shtml"},{"title":"一拳超人53话","sid":130,"id":1332474,"size":1.65,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145020.shtml"},{"title":"一拳超人番外篇4","sid":129,"id":1332473,"size":2.53,"counts":23,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145016.shtml"},{"title":"一拳超人52话","sid":128,"id":1332472,"size":1.35,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145012.shtml"},{"title":"一拳超人51话","sid":127,"id":1332471,"size":1.2,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145008.shtml"},{"title":"一拳超人50卷","sid":126,"id":1332470,"size":1.05,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145004.shtml"},{"title":"一拳超人番外篇3","sid":125,"id":1332469,"size":2.55,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1145000.shtml"},{"title":"一拳超人48卷","sid":124,"id":1332468,"size":1.2,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144996.shtml"},{"title":"一拳超人47卷","sid":123,"id":1332467,"size":1.2,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144992.shtml"},{"title":"一拳超人46卷","sid":122,"id":1332466,"size":1.05,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144988.shtml"},{"title":"一拳超人附赠漫画","sid":121,"id":1332465,"size":1,"counts":4,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144984.shtml"},{"title":"一拳超人特别篇","sid":120,"id":1332464,"size":10.73,"counts":29,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144980.shtml"},{"title":"一拳超人45卷","sid":119,"id":1332463,"size":1.05,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144976.shtml"},{"title":"一拳超人番外篇2","sid":118,"id":1332462,"size":2.76,"counts":23,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144972.shtml"},{"title":"一拳超人44卷","sid":117,"id":1332461,"size":1.05,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144968.shtml"},{"title":"一拳超人43卷","sid":116,"id":1332460,"size":1.05,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144964.shtml"},{"title":"一拳超人42卷","sid":115,"id":1332459,"size":1.65,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144960.shtml"},{"title":"一拳超人41卷","sid":114,"id":1332458,"size":1.8,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144956.shtml"},{"title":"一拳超人38-39卷","sid":113,"id":1332457,"size":2.1,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144952.shtml"},{"title":"一拳超人36-37卷","sid":112,"id":1332456,"size":1.8,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144948.shtml"},{"title":"一拳超人32-35卷","sid":111,"id":1332455,"size":2.4,"counts":60,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144944.shtml"},{"title":"一拳超人30-31卷","sid":110,"id":1332454,"size":2.4,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144940.shtml"},{"title":"一拳超人28-29卷","sid":109,"id":1332453,"size":6,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144936.shtml"},{"title":"一拳超人26-27卷","sid":108,"id":1332452,"size":5.4,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144932.shtml"},{"title":"一拳超人24-25卷","sid":107,"id":1332451,"size":3.6,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144928.shtml"},{"title":"一拳超人20.5卷","sid":106,"id":1332450,"size":1.61,"counts":23,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144920.shtml"},{"title":"一拳超人20卷","sid":105,"id":1332449,"size":1.19,"counts":17,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144912.shtml"},{"title":"一拳超人番外篇","sid":104,"id":1332448,"size":3.68,"counts":23,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144908.shtml"},{"title":"一拳超人19卷","sid":103,"id":1332447,"size":2.5,"counts":25,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144900.shtml"},{"title":"一拳超人18卷","sid":102,"id":1332446,"size":1.26,"counts":18,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144896.shtml"},{"title":"一拳超人17.5卷","sid":101,"id":1332445,"size":1.69,"counts":13,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144892.shtml"},{"title":"一拳超人16卷","sid":100,"id":1332444,"size":5.28,"counts":22,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144888.shtml"},{"title":"一拳超人15卷","sid":99,"id":1332443,"size":4.86,"counts":27,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144884.shtml"},{"title":"一拳超人14卷","sid":98,"id":1332442,"size":4.18,"counts":22,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144880.shtml"},{"title":"一拳超人13卷","sid":97,"id":1332441,"size":3,"counts":25,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144876.shtml"},{"title":"一拳超人12卷","sid":96,"id":1332440,"size":4.08,"counts":24,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144872.shtml"},{"title":"一拳超人11卷","sid":95,"id":1332439,"size":3.08,"counts":22,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144868.shtml"},{"title":"一拳超人10卷","sid":94,"id":1332438,"size":6.16,"counts":28,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144864.shtml"},{"title":"一拳超人07卷","sid":93,"id":1332437,"size":1.87,"counts":17,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144856.shtml"},{"title":"一拳超人06卷","sid":92,"id":1332436,"size":3.12,"counts":24,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144852.shtml"},{"title":"一拳超人05卷","sid":91,"id":1332435,"size":3.23,"counts":19,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144848.shtml"},{"title":"一拳超人04卷","sid":90,"id":1332434,"size":3.2,"counts":20,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144844.shtml"},{"title":"一拳超人03卷","sid":89,"id":1332433,"size":2.4,"counts":20,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144840.shtml"},{"title":"一拳超人02卷","sid":88,"id":1332432,"size":2.72,"counts":16,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144836.shtml"},{"title":"一拳超人01卷","sid":87,"id":1332431,"size":2.4,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1144832.shtml"},{"title":"原作篇90话","sid":86,"id":844673,"size":2.55,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1000238.shtml"},{"title":"崩坏版89话","sid":85,"id":844672,"size":3.75,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1000236.shtml"},{"title":"崩坏版88话","sid":84,"id":844671,"size":2.25,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1000234.shtml"},{"title":"崩坏版87话","sid":83,"id":844670,"size":4.05,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1000232.shtml"},{"title":"崩坏版86话","sid":82,"id":844669,"size":1.95,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1000230.shtml"},{"title":"崩坏版85话","sid":81,"id":844668,"size":5.1,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1000228.shtml"},{"title":"崩坏版84话","sid":80,"id":844667,"size":5.1,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1000226.shtml"},{"title":"30话","sid":79,"id":844666,"size":7.02,"counts":26,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1000224.shtml"},{"title":"29话","sid":78,"id":844665,"size":2.97,"counts":11,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/1000222.shtml"},{"title":"28话","sid":77,"id":844664,"size":4.5,"counts":18,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123886.shtml"},{"title":"崩坏版83话","sid":76,"id":844663,"size":1.35,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123884.shtml"},{"title":"崩坏版82话","sid":75,"id":844662,"size":2.1,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123882.shtml"},{"title":"27话","sid":74,"id":844661,"size":4.81,"counts":37,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123880.shtml"},{"title":"崩坏版81话","sid":73,"id":844660,"size":1.65,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123878.shtml"},{"title":"26话","sid":72,"id":844659,"size":5.52,"counts":46,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123876.shtml"},{"title":"25话","sid":71,"id":844641,"size":3.75,"counts":25,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123822.shtml"},{"title":"崩坏版80话","sid":70,"id":844658,"size":3.6,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123872.shtml"},{"title":"崩坏版79话","sid":69,"id":844657,"size":1.8,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123870.shtml"},{"title":"崩坏版78话","sid":68,"id":844656,"size":1.65,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123868.shtml"},{"title":"崩坏版77话","sid":67,"id":844655,"size":3.15,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123866.shtml"},{"title":"崩坏版76话","sid":66,"id":844654,"size":2.08,"counts":16,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123864.shtml"},{"title":"崩坏版74-75话","sid":65,"id":844653,"size":4.2,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123862.shtml"},{"title":"崩坏版73话","sid":63,"id":844652,"size":1.8,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123858.shtml"},{"title":"崩坏版72话","sid":62,"id":844651,"size":1.5,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123856.shtml"},{"title":"崩坏版71话","sid":61,"id":844650,"size":1.44,"counts":16,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123854.shtml"},{"title":"崩坏版70话","sid":60,"id":844649,"size":1.95,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123852.shtml"},{"title":"崩坏版69话","sid":59,"id":844648,"size":2.4,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123850.shtml"},{"title":"崩坏版68话","sid":58,"id":844647,"size":1.4,"counts":14,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123846.shtml"},{"title":"崩坏版67话","sid":57,"id":844646,"size":1.5,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123842.shtml"},{"title":"崩坏版66话","sid":56,"id":844645,"size":1.68,"counts":14,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123838.shtml"},{"title":"崩坏版65话","sid":55,"id":844644,"size":1.5,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123834.shtml"},{"title":"崩坏版64话","sid":54,"id":844643,"size":1.65,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123830.shtml"},{"title":"崩坏版62-63话","sid":53,"id":844642,"size":3,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123826.shtml"},{"title":"崩坏版60-61话","sid":52,"id":844640,"size":4.8,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123818.shtml"},{"title":"崩坏版59话","sid":51,"id":844639,"size":1.87,"counts":17,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123814.shtml"},{"title":"崩坏版58话","sid":50,"id":844638,"size":3.22,"counts":14,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123810.shtml"},{"title":"崩坏版57话","sid":49,"id":844637,"size":2.1,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123806.shtml"},{"title":"崩坏版56话","sid":48,"id":844636,"size":1.6,"counts":16,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123802.shtml"},{"title":"崩坏版55话","sid":47,"id":844635,"size":1.5,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123798.shtml"},{"title":"崩坏版54话","sid":46,"id":844634,"size":1.5,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123794.shtml"},{"title":"崩坏版53话","sid":45,"id":844633,"size":1.65,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123790.shtml"},{"title":"崩坏版52话","sid":44,"id":844632,"size":1.6,"counts":16,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123786.shtml"},{"title":"崩坏版50-51话","sid":43,"id":844631,"size":6.3,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123782.shtml"},{"title":"崩坏版49话","sid":42,"id":844630,"size":1.44,"counts":16,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123778.shtml"},{"title":"崩坏版48话","sid":41,"id":844629,"size":3.75,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123774.shtml"},{"title":"崩坏版46-47话","sid":40,"id":844628,"size":5.1,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123770.shtml"},{"title":"崩坏版45话","sid":39,"id":844627,"size":1.05,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123766.shtml"},{"title":"崩坏版44话","sid":38,"id":844626,"size":0.77,"counts":11,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123762.shtml"},{"title":"崩坏版43话","sid":37,"id":844625,"size":1.05,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123758.shtml"},{"title":"崩坏版42话","sid":36,"id":844624,"size":1.65,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123754.shtml"},{"title":"崩坏版40-41话","sid":35,"id":844623,"size":3,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123750.shtml"},{"title":"崩坏版38-39话","sid":34,"id":844622,"size":3.9,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123746.shtml"},{"title":"崩坏版36-37话","sid":33,"id":844621,"size":3.3,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123742.shtml"},{"title":"崩坏版32-35话","sid":32,"id":844620,"size":4.8,"counts":60,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123738.shtml"},{"title":"崩坏版30-31话","sid":31,"id":844619,"size":5.4,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123734.shtml"},{"title":"崩坏版28-29话","sid":30,"id":844618,"size":6,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123730.shtml"},{"title":"崩坏版26-27话","sid":29,"id":844617,"size":5.4,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123726.shtml"},{"title":"崩坏版24-25话","sid":28,"id":844616,"size":3.6,"counts":30,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123722.shtml"},{"title":"崩坏版20-23话","sid":27,"id":844615,"size":10.8,"counts":60,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123718.shtml"},{"title":"24话","sid":26,"id":844614,"size":8,"counts":16,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123714.shtml"},{"title":"23话","sid":25,"id":844613,"size":5.2,"counts":26,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123710.shtml"},{"title":"22话","sid":24,"id":844612,"size":2.53,"counts":23,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123706.shtml"},{"title":"21话","sid":23,"id":844611,"size":5.5,"counts":25,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123702.shtml"},{"title":"20话","sid":22,"id":844610,"size":2.52,"counts":14,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123694.shtml"},{"title":"19话","sid":20,"id":844609,"size":4.16,"counts":26,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123688.shtml"},{"title":"18话","sid":19,"id":844608,"size":2.28,"counts":12,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123682.shtml"},{"title":"17.5话","sid":18,"id":844607,"size":1.43,"counts":13,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123676.shtml"},{"title":"17话","sid":17,"id":844606,"size":4.96,"counts":31,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123670.shtml"},{"title":"16话","sid":16,"id":844605,"size":4.14,"counts":23,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123664.shtml"},{"title":"15话","sid":15,"id":844604,"size":4.68,"counts":26,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123658.shtml"},{"title":"14话","sid":14,"id":844603,"size":4.18,"counts":22,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123652.shtml"},{"title":"13话","sid":13,"id":844602,"size":3,"counts":25,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123646.shtml"},{"title":"12话","sid":12,"id":844601,"size":4.08,"counts":24,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123640.shtml"},{"title":"11话","sid":11,"id":844600,"size":3.08,"counts":22,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123634.shtml"},{"title":"10话","sid":10,"id":844599,"size":6.16,"counts":28,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123628.shtml"},{"title":"09话","sid":9,"id":844598,"size":2.64,"counts":24,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123622.shtml"},{"title":"08话","sid":8,"id":844597,"size":5.06,"counts":22,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123616.shtml"},{"title":"07话","sid":7,"id":844596,"size":3.57,"counts":17,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123610.shtml"},{"title":"06话","sid":6,"id":844595,"size":3.12,"counts":24,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123604.shtml"},{"title":"05话","sid":5,"id":844594,"size":3.23,"counts":19,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123596.shtml"},{"title":"04话","sid":4,"id":844593,"size":3.2,"counts":20,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123590.shtml"},{"title":"03话","sid":3,"id":844592,"size":2.4,"counts":20,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123584.shtml"},{"title":"02话","sid":2,"id":844591,"size":2.72,"counts":16,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123578.shtml"},{"title":"01话","sid":1,"id":844590,"size":2.4,"counts":15,"iszm":0,"surl":"http://www.7330.com/yiquanchaoren/123572.shtml"}]
     */

    private int status;
    /**
     * title : 100话
     * sid : 259
     * id : 2007323
     * size : 3.64
     * counts : 13
     * iszm : 0
     * surl : http://www.hanhande.com/yiquanchaoren/1154188.shtml
     */

    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String title;
        private int sid;
        private int id;
        private double size;
        private int counts;
        private int iszm;
        private String surl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getSize() {
            return size;
        }

        public void setSize(double size) {
            this.size = size;
        }

        public int getCounts() {
            return counts;
        }

        public void setCounts(int counts) {
            this.counts = counts;
        }

        public int getIszm() {
            return iszm;
        }

        public void setIszm(int iszm) {
            this.iszm = iszm;
        }

        public String getSurl() {
            return surl;
        }

        public void setSurl(String surl) {
            this.surl = surl;
        }
    }
}