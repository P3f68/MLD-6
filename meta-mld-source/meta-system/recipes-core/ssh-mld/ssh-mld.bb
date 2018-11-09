SUMMARY = "Init der MLD"
AUTHOTR = "Claus Muus <mld@clausmuus.de>"
HOMEPAGE ="http://www.minidvblinux.de"
SECTION = "base"
PN = "ssh-mld"

PR = "r1"

LICENSE = "MIT"
PACKAGE_ARCH = "${MACHINE_ARCH}"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

 

SRC_URI = " file://etc/init.d/ssh \
"

SRC_URI_append_arm = " file://alignment.sh"


do_install () {
	#
	# Directory erstellen
	#
	
	install -d ${D}${sysconfdir}/init.d
    install -d ${D}${localstatedir}/run	
	#
	# Dateien installieren
	#
	
    install -m 0755    ${WORKDIR}/etc/init.d/ssh						${D}${sysconfdir}/init.d
    
}
