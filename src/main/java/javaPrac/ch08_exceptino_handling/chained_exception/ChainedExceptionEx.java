package javaPrac.ch08_exceptino_handling.chained_exception;

public class ChainedExceptionEx {
    public static void main(String[] args) {
        try{
            install();
        } catch (InstallException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void install() throws InstallException{
        try{
            startInstall();
            copyFiles();
        } catch (SpaceException se) {
            InstallException ie = new InstallException("설치 중 예외발생");
            ie.initCause(se);
            throw ie;
        } catch (MemoryException me) {
            InstallException ie = new InstallException("설치 중 예외발생");
            ie.initCause(me);
            throw ie;
        } finally {
            deleteTimFiles();
        }
    }

    static void startInstall() throws SpaceException, MemoryException {
        if(!enoughSpace()){
            throw new SpaceException("설치할 공간이 부족합니다.");
        }

        if(!enoughMemory()){
            throw new MemoryException("메모리가 부족합니다.");
            //throw new RuntimeException(new MemoryException("메모리가 부족합니다."));
        }
    }

    static void copyFiles() { /* 파일들을 복사하는 코드를 적는다. */ }
    static void deleteTimFiles() { /*임시 파일을 삭제하는 코드 */ }

    static boolean enoughSpace() {
        // 설치하는데 필요한 공간이 있는지 확인하는 코드를 적는다.
        return false;
    }

    static boolean enoughMemory() {
        // 설치하는데 필요한 메모리공간이 있는지 확인하는 코드를 적는다.
        return true;
    }
}

class InstallException extends Exception {
    InstallException(String msg){
        super(msg);
    }
}

class SpaceException extends Exception {
    SpaceException(String msg) {
        super(msg);
    }
}

class MemoryException extends Exception {
    MemoryException(String msg) {
        super(msg);
    }
}