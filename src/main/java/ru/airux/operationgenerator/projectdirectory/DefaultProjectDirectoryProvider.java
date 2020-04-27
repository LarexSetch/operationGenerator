package ru.airux.operationgenerator.projectdirectory;

class DefaultProjectDirectoryProvider implements ProjectDirectoryProvider {
    @Override
    public String provide() {
        return System.getProperty("user.dir");
    }
}
