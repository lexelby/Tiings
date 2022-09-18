package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_02c
   extends TilingType
{
   public TilingTypeNC5_02c(){
      super( "NC5-2c", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 50,  0};
      paramName = new String[]{ "Length", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,5,0, 1},
            {1, 5,0, 0,3,4, 1},
            {1, 1,2, 2,2,1, 1},

            {0, 3,4, 3,5,0, 0},
            {0, 1,2, 4,5,0, 1},
            {1, 5,0, 5,3,4, 0},
            {1, 1,2, 6,2,1, 0},
      };
      labels = new int[]{0,1,2,-1,3,4};
      info = "a=c=d\nb=e\nA=30\nB=210\nC=60\nD=90\n(E=150)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 1.5*paramValues[0]/100.;
      double ln1 = 1.5-ln2;
      double h = ln1*Math.sqrt(3)/2;
      double os = ln1*getParam( paramValues, 1)/100.;
      
      baseTile.setPoint(0,  0,     0);
      baseTile.setPoint(1,ln2,     0);
      baseTile.setPoint(2,ln2+ h,-ln1/2);
      baseTile.setPoint(3,ln2+ h,-ln1/2+os);
      baseTile.setPoint(4,ln2+ h, ln1/2);
      baseTile.setPoint(5, h,     ln1/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[0].getX(2);
      offsets[1] = tiles[0].getY(4)-tiles[0].getY(2);
      offsets[2] = tiles[7].getX(0)-tiles[1].getX(3);
      offsets[3] = tiles[7].getY(0)-tiles[1].getY(3);
   }
}
