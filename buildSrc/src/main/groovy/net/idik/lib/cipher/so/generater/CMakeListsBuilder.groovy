package net.idik.lib.cipher.so.generater

class CMakeListsBuilder {

    private String originCMakePath
    private String cipherCMakePath

    CMakeListsBuilder(String cipherCMakePath) {
        this.cipherCMakePath = cipherCMakePath
    }

    def setOriginCMakePath(String originCMakePath) {
        this.originCMakePath = originCMakePath
        this
    }

    List<String> build() {
        List<String> lines = new ArrayList<>()
        lines.add("# Auto-Generated By CipherExt.so - 林帅斌(me@idik.net)\n\n")
        lines.add("cmake_minimum_required(VERSION 3.4.1)\n\n")
        lines.add("add_subdirectory(${new File(cipherCMakePath).parentFile.path} cipher.out)\n\n")
        if (originCMakePath != null) {
            lines.add("add_subdirectory(${new File(originCMakePath).parentFile.path} origin.out)\n\n")
        }
        lines
    }

}