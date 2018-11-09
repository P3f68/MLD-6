SUMMARY = "Init der MLD"
AUTHOTR = "Claus Muus <mld@clausmuus.de>"
HOMEPAGE ="http://www.minidvblinux.de"
SECTION = "base"
PN = "locales"

PR = "r2"

LICENSE = "MIT"
PACKAGE_ARCH = "${MACHINE_ARCH}"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

 

SRC_URI = " file://etc/init.d/locales \
            file://etc/setup/locales.sh \
            file://etc/setup/locales.xml \
            file://usr/bin/update_locales \
"

SRC_URI_append_arm = " file://alignment.sh"


do_install () {
	#
	# Directory erstellen
	#
    
    install -d ${D}${base_prefix}
	
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/setup
    install -d ${D}/usr/
    install -d ${D}/usr/bin
	
	#
	# Dateien installieren
	#
	
    install -m 0755    ${WORKDIR}/etc/init.d/locales						${D}${sysconfdir}/init.d

    install -m 0755    ${WORKDIR}/etc/setup/locales.sh						${D}${sysconfdir}/setup
    install -m 0755    ${WORKDIR}/etc/setup/locales.xml						${D}${sysconfdir}/setup
    
    install -m 0755    ${WORKDIR}/usr/bin/update_locales					${D}/usr/bin
}


