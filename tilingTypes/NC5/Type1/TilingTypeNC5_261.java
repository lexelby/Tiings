package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_261
   extends TilingType
{
   public TilingTypeNC5_261(){
      super( "NC5-261", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,2, 0},
            {2, 1,0, 1,4,0, 0},
            {1, 4,3, 0,3,4, 0},
            {0, 2,1, 3,1,2, 0},
            {2, 1,0, 4,4,0, 0},
      };
      info = "d=e\nb=a+2d\nA=90\nD=90\nE=270\n(B+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double ln1 = ln * getParam(paramValues, 0)/100;
      double ln2 = ln - ln1;

      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, ln1*2+ln2,   0);
      baseTile.setPoint(2, -ln1, ln1+ln2);
      baseTile.setPoint(3, -ln1, ln2);
      baseTile.setPoint(4,   0,  ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(1)-tiles[2].getX(2);
      offsets[3] = tiles[5].getY(1)-tiles[2].getY(2);
   }
}
