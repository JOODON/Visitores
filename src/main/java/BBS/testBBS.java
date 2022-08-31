package BBS;

public class testBBS {
    public static void main(String[] args) {

        String name="이선영";
        String text="테스트 페이지 본문2";
        BBS bbs=new BBS(name,text);
        BBSDAO bbsdao=new BBSDAO();

        bbsdao.adduser(bbs);

    }
}
