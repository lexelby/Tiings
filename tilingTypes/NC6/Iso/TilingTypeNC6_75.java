package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_75
   extends TilingType
{
   public TilingTypeNC6_75(){
      super( "NC6-75", 6, SymmetryType.p4 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 40, 20, 30};
      paramName = new String[]{"Relative Length", "X", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 5,2, 0,2,5, 0},
            {0, 0,5, 1,0,1, 0},
            {0, 5,2, 2,2,5, 0},
      };
      info = "a+c=b\nd=f\nA=90\nB=90\nD+E=360\n(C+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1.5;
      double ln1 = ln * getParam(paramValues,0)/100;
      double ln2 = ln-ln1;
      
      double x = ln * getParam(paramValues,1)/100;
      double y = ln * getParam(paramValues,2)/100;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, ln, ln1);
      baseTile.setPoint(3, ln-x, ln-y);
      baseTile.setPoint(4,  x,  y);
      baseTile.setPoint(5,  0, ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[0].getY(0);
   }
}