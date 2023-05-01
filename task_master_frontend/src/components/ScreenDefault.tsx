import { VStack, Image, Box, Heading, Avatar } from "native-base";
import { ReactNode } from "react";

interface ScreenDefaultProps {
  children: ReactNode;
  header?: string;
  student?: boolean;
}
export function ScreenDefault({
  children,
  header,
  student = false,
}: ScreenDefaultProps) {
  return (
    <>
      {header && (
        <Box
          backgroundColor={"#A8A1FC"}
          w={"100%"}
          py={6}
          flexDirection="row"
          alignItems="center"
          justifyContent="center"
          shadow="2"
          safeArea
        >
          {student && <Avatar bg={"gray.100"} mr={4} />}
          <Heading textAlign="center" color={"gray.100"}>
            {header}
          </Heading>
        </Box>
      )}
      <VStack
        flex={1}
        space={4}
        alignItems="center"
        justifyContent="flex-start"
        backgroundColor="#E7F0EF"
        px={3}
        safeArea
      >
        {!header && (
          <Image
            source={require("../assets/overlayer.png")}
            alt="Alternate Text"
            resizeMode="contain"
            position={"absolute"}
            top={0}
            left={0}
          />
        )}

        {children}
      </VStack>
    </>
  );
}
