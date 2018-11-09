# Das netinstall package 
# Beschreibt den Inhalt MLD Packages 

DESCRIPTION = "MLD Packages"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup 




RDEPENDS_packagegroup-mld-x86 = " \
    extlinux \
    syslinux-extlinux \
"




RDEPENDS_packagegroup-mld-kernel-modules = " \
	kernel-modules \
"

RDEPENDS_packagegroup-mld-install = " \
	init \
	install \
"

RDEPENDS_packagegroup-mld-tools = " \
	mc \
	nano \
"

RDEPENDS_packagegroup-mld-test-new-recipes = " \
	vtunerc \
	satip-client \
	packagegroup-core-eclipse-debug \
	packagegroup-core-ssh-openssh \
"


