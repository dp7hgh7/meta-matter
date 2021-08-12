PN = "otbr"
SUMMARY = "OTBR on i.MX boards"
DESCRIPTION = "OTBR applications"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "gitsm://github.com/openthread/ot-br-posix.git;branch=main"

SRCREV = "8e0ee639b174ab74ca9e90f4b2557f42336e9d8b"

S = "${WORKDIR}/git"
FILES_${PN} += "lib/systemd"
FILES_${PN} += "usr/share"

DEPENDS += " jsoncpp avahi boost "
RDEPENDS_${PN} += " jsoncpp libavahi-client "

inherit cmake
EXTRA_OECMAKE = "-GNinja -DOTBR_BORDER_ROUTING=ON -DOTBR_WEB=ON -DBUILD_TESTING=OFF -DOTBR_DBUS=OFF -DOTBR_DNSSD_DISCOVERY_PROXY=ON -DOTBR_SRP_ADVERTISING_PROXY=ON -DOT_THREAD_VERSION=1.1 -DOTBR_INFRA_IF_NAME=mlan0" 