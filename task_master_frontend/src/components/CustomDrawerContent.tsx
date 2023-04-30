import {
  DrawerContentComponentProps,
  DrawerContentScrollView,
} from "@react-navigation/drawer";
import { VStack, HStack, Pressable, Text, Divider, Avatar } from "native-base";
import { FontAwesome5 } from "@expo/vector-icons";
import React from "react";

const getTitle = (screenName: string) => {
  switch (screenName) {
    case "HomeScreen":
      return "Home";
    case "Student":
      return "Aluno";
    case "Matter":
      return "Matéria";
    case "Reports":
      return "Relátorios";
    case "Trash":
      return "trash-can";
    case "Spam":
      return "alert-circle";
    default:
      return undefined;
  }
};

export function CustomDrawerContent(props: DrawerContentComponentProps) {
  return (
    <DrawerContentScrollView {...props}>
      <VStack flex={1} space="6" my="2" mx="1" backgroundColor={"#ddd"}>
        <VStack divider={<Divider />} space="4">
          <VStack space="3">
            {props.state.routeNames.map((name, index) => (
              <Pressable
                key={index}
                px="5"
                py="2"
                rounded="md"
                bg={index === props.state.index ? "#ddd" : "transparent"}
                onPress={(event) => {
                  props.navigation.navigate(name);
                }}
              >
                <HStack space="7" alignItems="center">
                  {name === "HomeScreen" ? (
                    <Avatar bg={"gray.100"} />
                  ) : (
                    <Text
                      fontSize={"md"}
                      fontWeight="500"
                      color={
                        index === props.state.index ? "purple.700" : "gray.700"
                      }
                    >
                      {getTitle(name)}
                    </Text>
                  )}
                </HStack>
              </Pressable>
            ))}
          </VStack>
        </VStack>
      </VStack>
    </DrawerContentScrollView>
  );
}
