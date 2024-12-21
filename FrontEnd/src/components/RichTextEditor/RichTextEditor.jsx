import '../../styles.scss';
import styles from './RichTextEditor.module.css';

import React from 'react'
import { EditorProvider, useCurrentEditor } from '@tiptap/react'
import StarterKit from '@tiptap/starter-kit'
import TextStyle from '@tiptap/extension-text-style'
import ListItem from '@tiptap/extension-list-item'
import { Color } from '@tiptap/extension-color'
import Toggle from '../Toggle/Toggle'

//Icons
import { Heading2, Bold, Italic, Strikethrough, Code, List, ListOrdered, Undo, Redo } from 'lucide-react';

const MenuBar = () => {
  const { editor } = useCurrentEditor()

  if (!editor) {
    return null
  }

  return (
    <div className={styles.menuBar}>
      <Toggle pressed={editor.isActive('heading')}
        onPressedChange={() => editor.chain().focus().toggleHeading({ level: 2 }).run()}>
        <Heading2 />
      </Toggle>

      <Toggle pressed={editor.isActive('bold')}
        onPressedChange={() => editor.chain().focus().toggleBold().run()}>
        <Bold />
      </Toggle>

      <Toggle pressed={editor.isActive('italic')}
        onPressedChange={() => editor.chain().focus().toggleItalic().run()}>
        <Italic />
      </Toggle>

      <Toggle pressed={editor.isActive('strike')}
        onPressedChange={() => editor.chain().focus().toggleStrike().run()}>
        <Strikethrough />
      </Toggle>

      <Toggle pressed={editor.isActive('code')}
        onPressedChange={() => editor.chain().focus().toggleCode().run()}>
        <Code />
      </Toggle>

      <Toggle pressed={editor.isActive('bulletList')}
        onPressedChange={() => editor.chain().focus().toggleBulletList().run()}>
        <List />
      </Toggle>

      <Toggle pressed={editor.isActive('orderedList')}
        onPressedChange={() => editor.chain().focus().toggleOrderedList().run()}>
        <ListOrdered />
      </Toggle>

      <Toggle onPressedChange={() => editor.chain().focus().undo().run()}>
        <Undo />
      </Toggle>

      <Toggle onPressedChange={() => editor.chain().focus().redo().run()}>
        <Redo />
      </Toggle>
    </div>
  )
}

const extensions = [
  Color.configure({ types: [TextStyle.name, ListItem.name] }),
  TextStyle.configure({ types: [ListItem.name] }),
  StarterKit.configure({
    bulletList: {
      keepMarks: true,
      keepAttributes: false,
    },
    orderedList: {
      keepMarks: true,
      keepAttributes: false,
    },
  }),
]

export default ({ content, setContent}) => {
  return (
    <EditorProvider key={content} slotBefore={<MenuBar />} extensions={extensions} content={content} onBlur={({ editor }) => {
      setContent(editor.getHTML());
    }}></EditorProvider>
  )
}