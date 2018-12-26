# Simple initramfs image. Mostly used for live images.
DESCRIPTION = "Small image capable of booting a device. The kernel includes \
the Minimal RAM-based Initial Root Filesystem (initramfs), which finds the \
first 'init' program more efficiently."


# Base Packages
#PACKAGE_INSTALL = "${IMAGE_INSTALL} urldecode ifupdown e2fsprogs udev udev-mld init-mld network webserver \
#                    base findutils busybox gettext gettext-runtime kernel-modules \
#                    apt apt-mld dpkg-mld util-linux-blkid install btrfs-tools gptfdisk \
#                    syslinux extlinux initramfs ssh-mld dropbear "

# Base Packages
PACKAGE_INSTALL = " urldecode ifupdown e2fsprogs udev udev-mld init-mld network webserver \
                    base findutils busybox gettext gettext-runtime kernel-modules \
                    apt apt-mld dpkg-mld util-linux-blkid install btrfs-tools gptfdisk \
                    syslinux extlinux initramfs ssh-mld dropbear "

#PACKAGE_INSTALL += " ffmpeg vdr "

#Only for Testing
PACKAGE_INSTALL += " nano mc" 
#Only for Testing
PACKAGE_INSTALL += " nano mc"

# Do not pollute the initrd image with rootfs features
#IMAGE_FEATURES = "package-management"
#IMAGE_FEATURES = " splash"

EXTRA_IMAGE_FEATURES = " "

GLIBC_GENERATE_LOCALES = "de_DE.UTF-8"
IMAGE_LINGUAS ?= "de-de"

LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"

#inherit core-minimal-image
inherit image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"

INITRAMFS_MAXSIZE = "154108"
# Use the same restriction as initramfs-live-install
COMPATIBLE_HOST = "(i.86|x86_64).*-linux"

export IMAGE_BASENAME = "mld-initramfs-x86"

